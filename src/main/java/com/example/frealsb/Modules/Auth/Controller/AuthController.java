package com.example.frealsb.Modules.Auth.Controller;

import com.example.frealsb.Modules.Auth.Model.CustomUserDetail;
import com.example.frealsb.Modules.User.Model.User;
import com.example.frealsb.Modules.Auth.Request.RequestRegisterUser;
import com.example.frealsb.Modules.User.Service.UserService;
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

    @GetMapping("/me")
    public String GetCurrentUser(@AuthenticationPrincipal CustomUserDetail customUserDetail, Model model){
        User user = userService.currentUser();
        model.addAttribute("user", user);
        return "Layouts/Auth/Me";
    }

    @GetMapping("/change_password")
    public String ChangePassword(@AuthenticationPrincipal CustomUserDetail customUserDetail, Model model){
        User user = customUserDetail.getUser();
        model.addAttribute("user", user);
        return "Layouts/Auth/ChangePassword";
    }

    @PostMapping("/change_password")
    public String ChangePassword_Submit(@AuthenticationPrincipal CustomUserDetail customUserDetail, @RequestParam("password") String password, @RequestParam("confirmPassword") String confirmPassword, Model model){
        try {
            userService.changePassword(password, confirmPassword);
            return "redirect:/ChangePassword?done";
        }catch (Exception e){
            return "redirect:/ChangePassword?error";
        }
    }
}
