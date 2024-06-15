package com.example.frealsb.Services.Interface;

import com.example.frealsb.Entities.Post;

import java.util.List;

public interface IPostService {
    public List<Post> getPosts(String s, int page, int size);
    public Post getPost(String id);
    public Post addPost(Post post);
    public Post updatePost(Post post);
    public void deletePost(String id);
    public List<Post> getPostsOfUser(String userId);
    public List<Post> getPostsNew();
}
