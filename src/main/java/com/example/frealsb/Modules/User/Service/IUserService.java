package com.example.frealsb.Modules.User.Service;

import com.example.frealsb.Modules.User.Model.User;
import com.example.frealsb.Modules.Auth.Request.RequestRegisterUser;
import jakarta.security.auth.message.AuthException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

public interface IUserService extends UserDetailsService {

    User findByEmail(String email);

    boolean emailExists(String email);

    User register(RequestRegisterUser req);

    void changeEmail(String newEmail, String currentPassword) throws AuthException;

    void changePassword(String newPassword, String currentPassword) throws AuthException;

    void changeProfileInfo(User newProfileInfo);

    void changeAvatar(MultipartFile file);

    void removeAvatar();

    void authenticate(User user);

    boolean isAuthenticated();

    boolean isAdmin();

    User currentUser();
}
