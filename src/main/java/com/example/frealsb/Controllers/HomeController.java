package com.example.frealsb.Controllers;

import com.example.frealsb.Modules.Auth.Model.CustomUserDetail;
import com.example.frealsb.Modules.User.Model.User;
import com.example.frealsb.Modules.Event.Service.IEventService;
import com.example.frealsb.Modules.FriendRequest.Service.IFriendRequestService;
import com.example.frealsb.Modules.Post.Service.IPostService;
import com.example.frealsb.Modules.User.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @Autowired
    private IPostService postService;
    @Autowired
    private IEventService eventService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IFriendRequestService friendRequestService;

    @GetMapping("/")
    public String Register(@AuthenticationPrincipal CustomUserDetail customUserDetail, Model model){
        User user = customUserDetail.getUser();
        model.addAttribute("posts", postService.getPostsNew());
        model.addAttribute("user", userService.currentUser());
        model.addAttribute("friends", userService.currentUser());
        model.addAttribute("friendRequests", friendRequestService.getPendingRequests(user.getId()));
        model.addAttribute("events", eventService.getClass());
        return "Layouts/Home/index";
    }

    @PostMapping("/add_friend")
    public String addFriend(@AuthenticationPrincipal CustomUserDetail customUserDetail, @PathVariable String requestId){
        User user = customUserDetail.getUser();
//        model.addAttribute("posts", postService.getPostsNew());
        return "redirect:/index";
    }

    /*@PostMapping("/add_friend")
    public String declineFriend(@AuthenticationPrincipal CustomUserDetail customUserDetail, Model model){
        User user = customUserDetail.getUser();
        model.addAttribute("posts", postService.getPostsNew());
    }*/
}
