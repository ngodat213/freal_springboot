package com.example.frealsb.Services.Interface;

import com.example.frealsb.Entities.Post;

import java.util.List;

public interface IPostService {
    // __CURD__ //
    List<Post> getPosts(String s, int page, int size);
    Post getPost(String id);
    Post addPost(Post post);
    Post updatePost(Post post);
    void deletePost(String id);
    // __FUTURE__ //
    List<Post> getPostsOfUser(String userId);
    List<Post> getPostsNew();
}
