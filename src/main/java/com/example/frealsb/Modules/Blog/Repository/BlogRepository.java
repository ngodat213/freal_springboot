package com.example.frealsb.Modules.Blog.Repository;

import com.example.frealsb.Modules.Blog.Model.Blog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, String> {
    List<Blog> findAllBy(String s, Pageable pageable);
}
