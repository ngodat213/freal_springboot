package com.example.frealsb.Modules.Post.Controller;

import com.example.frealsb.Modules.Post.Model.Post;
import com.example.frealsb.Modules.Post.Service.PostService;
import com.example.frealsb.Util.Model.PaginationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/blogs")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("")
    public String getProducts (
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(defaultValue = "desc", name = "sort") String sortDirection,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            Model model
    ){
        PaginationDTO paginationDTO = new PaginationDTO(page, limit, sortDirection, sortBy);
        model.addAttribute("posts", postService.getPosts(paginationDTO));
        return "Layout/Post/index";
    }

    @GetMapping("search")
    public String search(){

        return "Layout/Post/search";
    }
}
