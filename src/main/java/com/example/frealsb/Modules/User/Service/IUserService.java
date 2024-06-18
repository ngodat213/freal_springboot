package com.example.frealsb.Modules.User.Service;

import com.example.frealsb.Modules.Auth.Request.UserPasswordChange;
import com.example.frealsb.Modules.Auth.Request.UserPasswordReset;
import com.example.frealsb.Modules.User.Model.User;
import com.example.frealsb.Modules.Auth.Request.RequestRegisterUser;
import jakarta.security.auth.message.AuthException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

public interface IUserService extends UserDetailsService {

    User findByEmail(String email);

    User register(RequestRegisterUser req);

    boolean isAuthenticated();

    User currentUser();

    User getUserByUsername(String email);

    void UpdateFailCount(User user);

    boolean checkOldPassword(User authenticatedUser, String oldPassword);

    void UpdatePassword(User authenticatedUser, UserPasswordChange userPasswordChange);

    void handleResetPassword(UserPasswordReset userPasswordReset);

    void ResetLoginFail(User user);

    User getUserByEmail(String email);

    void GenTokenResetPassword(User user);

    String GenToken(int Length);

    User getUserByToken(String token);
}
