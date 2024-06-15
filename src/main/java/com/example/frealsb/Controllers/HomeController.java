package com.example.frealsb.Controllers;

import com.example.frealsb.Services.Interface.IEventService;
import com.example.frealsb.Services.Interface.IPostService;
import com.example.frealsb.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private IPostService postService;
    @Autowired
    private IEventService eventService;
    @Autowired
    private UserService userService;
    @Autowired


    @GetMapping("/")
    public String Register(Model model){
        return "Layouts/Home/index";
    }
}
