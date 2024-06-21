package com.example.frealsb.Modules.AdminDashboard.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class AdminDashboardController {

    @GetMapping("")
    public String dashboard (){
        return "Layouts/Dashboard/index";
    }
    @GetMapping("mail_box")
    public String mailBox (){
        return "Layouts/Dashboard/mail_box";
    }

    @GetMapping("chat")
    public String chat (){
        return "Layouts/Dashboard/chat";
    }

    @GetMapping("invoice")
    public String invoice (){
        return "Layouts/Dashboard/invoice";
    }
}
