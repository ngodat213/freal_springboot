package com.example.frealsb.Modules.Blog.Controller;

import com.example.frealsb.Modules.Blog.Service.BlogService;
import com.example.frealsb.Util.Model.PaginationDTO;
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
                           @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
                           @RequestParam(defaultValue = "desc", name = "sort") String sortDirection,
                           @RequestParam(defaultValue = "createdAt") String sortBy,
                           Model model) {
        PaginationDTO paginationDTO = new PaginationDTO(page, limit, sortDirection, sortBy);
        model.addAttribute("blogs", blogService.getBlogs(search, paginationDTO));
        return "Layouts/Blogs/index";
    }
}
