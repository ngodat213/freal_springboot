package com.example.frealsb.Services.Interface;

import com.example.frealsb.Entities.Blog;
import com.example.frealsb.Entities.User;
import com.example.frealsb.RequestEntities.RequestBlog;

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
