package com.example.frealsb.Services.Interface;

import com.example.frealsb.Entities.Blog;
import com.example.frealsb.Entities.User;
import com.example.frealsb.RequestEntities.RequestBlog;

import java.util.List;

public interface IBlogService {
    // __CURD__ //
    public List<Blog> getBlogs(String s, int page, int size);
    public Blog getBlog(String id);
    public Blog addBlog(RequestBlog req, User user);
    public Blog updateBlog(RequestBlog req);
    public void deleteBlog(String id);
    // __FEATURE__ //
}
