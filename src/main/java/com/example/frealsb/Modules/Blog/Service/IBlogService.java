package com.example.frealsb.Modules.Blog.Service;

import com.example.frealsb.Modules.Blog.Model.Blog;
import com.example.frealsb.Modules.User.Model.User;
import com.example.frealsb.Modules.Blog.RequestBlog;

import java.util.List;

public interface IBlogService {
    // __CURD__ //
    List<Blog> getBlogs(String s, int page, int size);
    Blog getBlog(String id);
    Blog addBlog(RequestBlog req, User user);
    Blog updateBlog(RequestBlog req);
    Blog deleteBlog(String id);
    // __FEATURE__ //
}
