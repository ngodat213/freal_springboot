package com.example.frealsb.Modules.Post.Service;

import com.example.frealsb.Modules.Post.Model.Post;
import com.example.frealsb.Modules.Comment.CommentRepository;
import com.example.frealsb.Modules.Post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    //  CRUD
    @Override
    public List<Post> getPosts(String s, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return postRepository.findAllBy(s, pageable);
    }

    @Override
    public Post getPost(String id) {
        return postRepository.findById(id).get();
    }

    @Override
    public Post addPost(Post post) {
        return postRepository.saveAndFlush(post);
    }

    @Override
    public Post updatePost(Post post) {
        return postRepository.saveAndFlush(post);
    }

    @Override
    public Post deletePost(String id) {
        Post post = getPost(id);
        post.setDeleted(true);
        return postRepository.saveAndFlush(post);
    }

    //
    @Override
    public List<Post> getPostsOfUser(String userId) {
        return postRepository.postsOfUser(userId);
    }

    @Override
    public List<Post> getPostsNew() {
        return postRepository.findAllByOrderByCreateAtDesc();
    }
}
