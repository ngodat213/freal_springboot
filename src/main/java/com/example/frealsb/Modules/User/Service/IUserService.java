package com.example.frealsb.Modules.User.Service;

import com.example.frealsb.Modules.Auth.Request.UserPasswordChange;
import com.example.frealsb.Modules.Auth.Request.UserPasswordReset;
import com.example.frealsb.Modules.User.Model.User;
import com.example.frealsb.Modules.Auth.Request.RequestRegisterUser;
import com.example.frealsb.Util.Model.PaginationDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    List<User> getAll(PaginationDTO paginationDTO);

    User findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

    User register(RequestRegisterUser req);

    User createUser(User user);

    boolean isAuthenticated();

    User currentUser();

    User getUserByUsername(String email);

    void UpdateFailCount(User user);

    boolean checkOldPassword(User authenticatedUser, String oldPassword);

    void UpdatePassword(User authenticatedUser, UserPasswordChange userPasswordChange);

    void handleResetPassword(UserPasswordReset userPasswordReset);

    boolean handleLockUser(String id);

    void ResetLoginFail(User user);

    User getUserByEmail(String email);

    void GenTokenResetPassword(User user);

    String GenToken(int Length);

    User getUserByToken(String token);
}
