package com.example.frealsb.Controllers;

import com.example.frealsb.Modules.Auth.Model.CustomUserDetail;
import com.example.frealsb.Modules.Post.Request.RequestPost;
import com.example.frealsb.Modules.User.Model.User;
import com.example.frealsb.Modules.Event.Service.IEventService;
import com.example.frealsb.Modules.FriendRequest.Service.IFriendRequestService;
import com.example.frealsb.Modules.Post.Service.IPostService;
import com.example.frealsb.Modules.User.Service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String home(@AuthenticationPrincipal CustomUserDetail customUserDetail, Model model){
        User user = customUserDetail.getUser();
        // Request
        model.addAttribute("postForm", new RequestPost());
        // Get
        model.addAttribute("posts", postService.getPostsNew());
        model.addAttribute("user", userService.currentUser());
        model.addAttribute("friends", userService.currentUser());
        model.addAttribute("friendRequests", friendRequestService.getPendingRequests(user.getId()));
        model.addAttribute("events", eventService.getClass());
        return "Layouts/Home/index";
    }

    @PostMapping("/post_submit")
    public String postSubmit(@AuthenticationPrincipal CustomUserDetail customUserDetail, @Valid RequestPost req, BindingResult bindingResult, @RequestParam("imageFiles") MultipartFile[] imageFiles, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "redirect:/";
        }
        postService.addPost(customUserDetail.getUser(), req, imageFiles);
        return "redirect:/";
    }

    @PostMapping("/add_friend")
    public String addFriend(@AuthenticationPrincipal CustomUserDetail customUserDetail, @PathVariable String requestId){
        User user = customUserDetail.getUser();
        return "redirect:/index";
    }
}
