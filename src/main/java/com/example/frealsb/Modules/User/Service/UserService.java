package com.example.frealsb.Modules.User.Service;

import com.example.frealsb.Excepciton.DuplicateResourceException;
import com.example.frealsb.Modules.Auth.Request.UserPasswordChange;
import com.example.frealsb.Modules.Auth.Request.UserPasswordReset;
import com.example.frealsb.Modules.User.Model.Otp;
import com.example.frealsb.Modules.User.Model.User;
import com.example.frealsb.Modules.User.Reponsitory.OtpRepository;
import com.example.frealsb.Modules.User.Reponsitory.UserRepository;
import com.example.frealsb.Modules.Auth.Request.RequestRegisterUser;
import com.example.frealsb.Util.Model.PaginationDTO;
import com.example.frealsb.Util.PaginationService;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PaginationService paginationService;
    @Autowired
    private OtpRepository otpRepository;

    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<User> getAll(PaginationDTO paginationDTO) {
        Pageable pageable = paginationService.getPageable(paginationDTO);
        return userRepository.findAll(pageable).toList();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByPhone(String phone) {
        return userRepository.existsByPhone(phone);
    }

    @Override
    public User register(RequestRegisterUser req) {
        if(!userRepository.existsByEmail(req.getEmail())){
            if(checkPassword(req.getPassword(), req.getConfirmPassword())) {
                req.setPassword(encodePassword(req.getPassword()));

                final User user = req.toUser();
                return userRepository.saveAndFlush(user);
            }else{
                throw new DuplicateResourceException("Password and confirm password is not equals");
            }
        }else{
            throw new DuplicateResourceException("The user with email [%s] already exists".formatted(req.getEmail()));
        }
    }

    @Override
    public User createUser(User user) {
        user.setPassword(encodePassword(user.getPassword()));
        return userRepository.saveAndFlush(user);
    }

    @Override
    public boolean isAuthenticated() {
        SecurityContext securityContext = SecurityContextHolder.getContext();

        Authentication auth = securityContext.getAuthentication();

        return auth != null && !(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated();
    }

    @Override
    public User currentUser() {
        if(!isAuthenticated()){
            return null;
        }
        SecurityContext securityContext = SecurityContextHolder.getContext();

        Authentication auth = securityContext.getAuthentication();

        return userRepository.findByEmail(auth.getName());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public boolean checkOldPassword(User user, String oldPassword) {
        if(checkCryptCompare(user.getPassword(), oldPassword)) {
            return true;
        }
        return false;
    }

    @Override
    public void UpdatePassword(User authenticatedUser, UserPasswordChange userPasswordChange) {
        Optional.of(authenticatedUser).stream()
                .filter(u->checkCryptCompare(
                        userPasswordChange.oldPassword(), u.getPassword()))
                .map(u->{
                    u.setPassword(encodePassword(userPasswordChange.newPassword()));
                    return userRepository.saveAndFlush(u);
                });
    }

    @Override
    public void handleResetPassword(UserPasswordReset userPasswordReset){
        User user = findByEmail(userPasswordReset.email());
        Otp otp = otpRepository.findByUser_Id(user.getId())
                .filter(o -> o.getExpiredAt().isAfter(LocalDateTime.now()))
                .filter(o -> o.getCode().equals(userPasswordReset.otpCode()))
                .orElseThrow(() -> new RuntimeException("Invalid otp code"));
        user.setPassword(passwordEncoder.encode(userPasswordReset.newPassword()));
        userRepository.save(user);
        otpRepository.delete(otp);
    }

    @Override
    public User getUserByUsername(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void UpdateFailCount(User user){
        int count = userRepository.countFailByEmail(user.getEmail());
        if(user.getLockExpired().getTime()<System.currentTimeMillis()){
            user.setEnabled(true);
            user.setLockExpired(null);
            user.setCountFail(0);
        }
        user.setCountFail(count+1);
        if(count==3){
            user.setEnabled(false);
            user.setLockExpired(new Date(System.currentTimeMillis()+1000*60*15));
        }
        userRepository.save(user);
    }

    @Override
    public void ResetLoginFail(User user){
        user.setLockExpired(null);
        user.setCountFail(0);
        userRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void GenTokenResetPassword(User user){
        user.setTokenResetPassword(GenToken(45));
        user.setTokenResetPasswordExpired(new Date(System.currentTimeMillis()+1000*60*10));
        userRepository.save(user);
    }

    @Override
    public String GenToken(int Length){
        return "1111";
    }

    @Override
    public User getUserByToken(String token){
        return userRepository.findByToken(token);
    }

    // Private method
    private boolean checkCryptCompare(String password, String oldPassword){
        return new BCryptPasswordEncoder().matches(oldPassword, password);
    }

    private boolean checkPassword(String password, String comfirmPassword) {
        return password.equals(comfirmPassword);
    }

    private String encodePassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}