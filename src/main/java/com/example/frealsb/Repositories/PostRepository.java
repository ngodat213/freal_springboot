package com.example.frealsb.Repositories;

import com.example.frealsb.Entities.Location;
import com.example.frealsb.Entities.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {
    List<Post> findAllBy(String s, Pageable pageable);

    @Query("SELECT r FROM Post r where r.user.id=?1 ")
    List<Post> postsOfUser(String userId);

    @Query("SELECT p FROM Post p ORDER BY p.createdAt DESC")
    List<Post> findAllByOrderByCreateAtDesc();
}
