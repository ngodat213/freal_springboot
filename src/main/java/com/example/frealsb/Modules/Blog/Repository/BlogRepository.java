package com.example.frealsb.Modules.Blog.Repository;

import com.example.frealsb.Modules.Blog.Model.Blog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, String> {
    @Query("SELECT p FROM Blog p WHERE " +
            "(UPPER(p.title) LIKE CONCAT('%', UPPER(:keyword), '%')) ")
    List<Blog> findWithKeyword(@Param("keyword") String keyword, Pageable pageable);
}