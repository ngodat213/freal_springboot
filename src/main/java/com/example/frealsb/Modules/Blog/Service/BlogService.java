package com.example.frealsb.Modules.Blog.Service;

import com.example.frealsb.Modules.Blog.Model.Blog;
import com.example.frealsb.Modules.User.Model.User;
import com.example.frealsb.Modules.Blog.Repository.BlogRepository;
import com.example.frealsb.Modules.Blog.RequestBlog;
import com.example.frealsb.Util.Model.PaginationDTO;
import com.example.frealsb.Util.PaginationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private PaginationService paginationService;

    @Override
    public List<Blog> getBlogs(String s, PaginationDTO paginationDTO) {
        Pageable pageable = paginationService.getPageable(paginationDTO);
        return blogRepository.findWithKeyword(s, pageable);
    }

    @Override
    public Blog getBlog(String id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public Blog addBlog(RequestBlog req, User user) {
        return blogRepository.saveAndFlush(req.toAddData(user));
    }

    @Override
    public Blog updateBlog(RequestBlog req) {
        return blogRepository.saveAndFlush(req.toUpdateData());
    }

    @Override
    public Blog deleteBlog(String id) {
        Blog blog = getBlog(id);
        blog.setDeleted(true);
        return blogRepository.saveAndFlush(blog);
    }
}
