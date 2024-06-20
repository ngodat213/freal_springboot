package com.example.frealsb.Modules.Post.Service;

import com.example.frealsb.Modules.Post.Model.Post;
import com.example.frealsb.Modules.Comment.CommentRepository;
import com.example.frealsb.Modules.Post.PostRepository;
import com.example.frealsb.Modules.Post.Request.RequestPost;
import com.example.frealsb.Modules.User.Model.User;
import com.example.frealsb.Util.ImageService;
import com.example.frealsb.Util.Model.PaginationDTO;
import com.example.frealsb.Util.PaginationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional
public class PostService implements IPostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PaginationService paginationService;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ImageService imageService;

    //  CRUD
    @Override
    public List<Post> getPosts(PaginationDTO paginationDTO) {
        Pageable pageable = paginationService.getPageable(paginationDTO);
        return postRepository.findAll(pageable).toList();
    }

    @Override
    public Post getPost(String id) {
        return postRepository.findById(id).get();
    }

    @Override
    public Post addPost(User user, RequestPost req, MultipartFile[] images) {
        Post post = req.toAddData();
        post.setUser(user);
        post.setImages(imageService.uploadImages(images));
        return postRepository.saveAndFlush(post);
    }

    @Override
    public Post updatePost(User user, RequestPost req) {
        return postRepository.saveAndFlush(req.toUpdateData());
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
