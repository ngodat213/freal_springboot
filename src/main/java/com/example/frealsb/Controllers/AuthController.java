package com.example.frealsb.Controllers;

import com.example.frealsb.Entities.CustomUserDetail;
import com.example.frealsb.Entities.User;
import com.example.frealsb.RequestEntities.RequestRegisterUser;
import com.example.frealsb.Services.UserService;
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
