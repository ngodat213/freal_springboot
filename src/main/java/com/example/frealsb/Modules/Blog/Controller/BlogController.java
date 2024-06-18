package com.example.frealsb.Modules.Blog.Controller;

import com.example.frealsb.Modules.Blog.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/blogs")
    public String allBlogs(@RequestParam(value = "search", required = false, defaultValue = "") String search,
                           @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                           @RequestParam(value = "size", required = false, defaultValue = "10") int size,
                           Model model) {

        model.addAttribute("blogs", blogService.getBlogs(search, page, size));
        return "Layouts/Blogs/index";
    }
}
