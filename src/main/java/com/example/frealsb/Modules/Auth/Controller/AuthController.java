package com.example.frealsb.Modules.Auth.Controller;

import com.example.frealsb.Modules.Auth.Model.CustomUserDetail;
import com.example.frealsb.Modules.Auth.Request.UserPasswordChange;
import com.example.frealsb.Modules.Auth.Request.UserPasswordReset;
import com.example.frealsb.Modules.User.Model.User;
import com.example.frealsb.Modules.Auth.Request.RequestRegisterUser;
import com.example.frealsb.Modules.User.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;

    /**
     * @layout: <a href="https://localhost:8080/register">...</a>
     * @method: GET
     */
    @GetMapping("/register")
    public String Register(Model model){
        RequestRegisterUser registerUser = new RequestRegisterUser();
        model.addAttribute("registerUser", registerUser);
        return "Layouts/Auth/Register";
    }

    /**
     * @layout: <a href="https://localhost:8080/register">...</a>
     * @method: POST
     */
    @PostMapping("/register_submit")
    public String CreateUser(RequestRegisterUser registerUser){
        userService.register(registerUser);
        return "redirect:/login";
    }

    /**
     * @layout: <a href="https://localhost:8080/login">...</a>
     * @method: GET
     */
    @GetMapping("/login")
    public String Login(){
        return "Layouts/Auth/Login";
    }

    /**
     * @layout: <a href="https://localhost:8080/me">...</a>
     * @method: GET
     */
    @GetMapping("/me")
    public String GetCurrentUser(@AuthenticationPrincipal CustomUserDetail customUserDetail, Model model){
        User user = userService.currentUser();
        model.addAttribute("user", user);
        return "Layouts/Auth/Me";
    }

    /**
     * @layout: <a href="https://localhost:8080/change_password">...</a>
     * @method: GET
     */
    @GetMapping("/change_password")
    public String  ChangePassword(@AuthenticationPrincipal CustomUserDetail customUserDetail, Model model){
        model.addAttribute("user", customUserDetail.getUser());
        return "Layout/Auth/changepassword";
    }

    /**
     * @layout: <a href="https://localhost:8080/change_password">...</a>
     * @method: POST
     */
    @PostMapping("change_password")
    public String SavePassword(@AuthenticationPrincipal CustomUserDetail customUserDetail,
                               @Valid @RequestBody UserPasswordChange userPasswordChange){
        User user = customUserDetail.getUser();
        if(userService.checkOldPassword(user, userPasswordChange.oldPassword())){
            userService.UpdatePassword(user, userPasswordChange);
            return "redirect:/change_password?done";
        }else{
            return "redirect:/change_password?error";
        }
    }

    /**
     * @layout: <a href="https://localhost:8080/forgot_password">...</a>
     * @method: GET
     */
    @GetMapping("forgot_password")
    public String ForgotPassword(){
        return "Layout/Auth/forgotpassword";
    }

    /**
     * @layout: <a href="https://localhost:8080/forgot_password">...</a>
     * @method: POST
     */
    @PostMapping("/forgot_password")
    public String ForgotPassword(@RequestParam("email") String email){
        User user = userService.getUserByEmail(email);
        if(user != null){
            userService.GenTokenResetPassword(user);
        }
        return "redirect:/forgotpassword";
    }

    /**
     * @layout: <a href="https://localhost:8080/reset_password">...</a>
     * @method: GET
     */
    @GetMapping("/reset_password")
    public String ResetPassword(@RequestParam("token") String token,Model model){
        User user = userService.getUserByToken(token);
        if(user != null){
            model.addAttribute("user", user);
        }
        return "Layout/Auth/reset_password";
    }

    /**
     * @layout: <a href="https://localhost:8080/reset_password">...</a>
     * @method: POST
     */
    @PostMapping("/reset_password")
    public String ResetPassword_Save(@Valid @RequestBody UserPasswordReset userPasswordReset){
        userService.handleResetPassword(userPasswordReset);
        return "redirect:/login";
    }
}
