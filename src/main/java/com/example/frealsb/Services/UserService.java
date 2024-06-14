package com.example.frealsb.Services;

import com.example.frealsb.Const.Constants;
import com.example.frealsb.Entities.User;
import com.example.frealsb.Repositories.RoleRepository;
import com.example.frealsb.Repositories.UserRepository;
import com.example.frealsb.RequestEntities.RequestRegisterUser;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import com.example.frealsb.Services.Interface.IUserService;
import com.example.frealsb.Util.EncryptionUtils;
import jakarta.security.auth.message.AuthException;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository _userRepository;
    @Autowired
    private RoleRepository _roleRepository;
    @Autowired
    private CloudinaryService _cloudinaryService;

    @Override
    public User findByEmail(String email) {
        return _userRepository.findByEmail(email);
    }

    @Override
    public boolean emailExists(String email) {
        return findByEmail(email) != null;
    }

    @Override
    public User register(RequestRegisterUser req) {
        try{
            if(req.getPassword().equals(req.getConfirmPassword()) ) {
                req.setPassword(new BCryptPasswordEncoder().encode(req.getPassword()));
                final User user = req.toUser(_roleRepository.findOneByName("USER"));
                return _userRepository.saveAndFlush(user);
            }else{
                throw new BadRequestException("Confirm password is not equals");
            }
        } catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void changeEmail(String newEmail, String currentPassword) throws AuthException {
        User user = currentUser();
        if (!new BCryptPasswordEncoder().matches(currentPassword, user.getPassword()))
            throw new AuthException("password does not match");

        user.setEmail(newEmail);

        _userRepository.saveAndFlush(user);
    }

    @Override
    public void changePassword(String newPassword, String currentPassword) throws AuthException {
        User user = currentUser();

        if (!EncryptionUtils.PasswordMatch(currentPassword, user))
            throw new AuthException("password does not match");

        user.setPassword(EncryptionUtils.PasswordEncoder(newPassword));
        // Sử dụng saveAndFlush khi bạn cần đảm bảo dữ liệu được ghi vào cơ sở dữ liệu ngay lập tức
        _userRepository.saveAndFlush(user);
    }

    @Override
    public void changeProfileInfo(User newProfileInfo) {
        User user = currentUser();

        user.setBio(newProfileInfo.getBio());

        _userRepository.saveAndFlush(user);
    }

    @Override
    public void changeAvatar(MultipartFile file) {
        final String avatarUrl =  _cloudinaryService.uploadFile(file);

        User user = currentUser();
        user.setAvatarPublicId(avatarUrl);

        _userRepository.saveAndFlush(user);
    }

    @Override
    public void removeAvatar() {
        User user = currentUser();

        user.setAvatarPublicId(Constants.DEFAULT_AVATAR);

        _userRepository.saveAndFlush(user);
    }

    @Override
    public void authenticate(User user) {
        UserDetails userDetails = loadUserByUsername(user.getEmail());

        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    @Override
    public boolean isAuthenticated() {
        SecurityContext securityContext = SecurityContextHolder.getContext();

        Authentication auth = securityContext.getAuthentication();

        return auth != null && !(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated();
    }

    @Override
    public boolean isAdmin() {
        User user = currentUser();

        return user != null && user.hasRole("ADMIN");
    }

    @Override
    public User currentUser() {
        if(!isAuthenticated()){
            return null;
        }
        SecurityContext securityContext = SecurityContextHolder.getContext();

        Authentication auth = securityContext.getAuthentication();

        return _userRepository.findByEmail(auth.getName());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
