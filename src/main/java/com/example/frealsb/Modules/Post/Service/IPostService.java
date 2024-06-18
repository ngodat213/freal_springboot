package com.example.frealsb.Modules.Post.Service;

import com.example.frealsb.Modules.Post.Model.Post;

import java.util.List;

public interface IPostService {
    // __CURD__ //
    List<Post> getPosts(String s, int page, int size);
    Post getPost(String id);
    Post addPost(Post post);
    Post updatePost(Post post);
    Post deletePost(String id);
    // __FUTURE__ //
    List<Post> getPostsOfUser(String userId);
    List<Post> getPostsNew();
}
