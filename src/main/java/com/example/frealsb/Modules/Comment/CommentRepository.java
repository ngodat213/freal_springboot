package com.example.frealsb.Modules.Comment;

import com.example.frealsb.Modules.Comment.Model.Comment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, String> {
    List<Comment> findAllBy(String s, Pageable pageable);
}
