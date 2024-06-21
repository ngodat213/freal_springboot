package com.example.frealsb.Modules.Post.Service;

import com.example.frealsb.Modules.Post.Model.Post;
import com.example.frealsb.Modules.Post.Request.RequestPost;
import com.example.frealsb.Modules.User.Model.User;
import com.example.frealsb.Util.Model.PaginationDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IPostService {
    // __CURD__ //
    List<Post> getPosts(PaginationDTO paginationDTO);
    Post getPost(String id);
    Post addPost(User user, RequestPost req, MultipartFile[] images);
    Post updatePost(User user,RequestPost req);
    Post deletePost(String id);
    // __FUTURE__ //
    List<Post> getPostsOfUser(String userId);
    List<Post> getPostsNew();
}
