package com.example.frealsb.RequestEntities;

import com.example.frealsb.Entities.Blog;
import com.example.frealsb.Entities.Tag;
import com.example.frealsb.Entities.User;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestBlog {
    private String title;
    private String description;
    private String images;
    private String location;
    private List<Tag> tags;

    public Blog toAddBlog(User user){
        Blog blog = new Blog();
        blog.setUser(user);
        blog.setTitle(title);
        blog.setDescription(description);
        blog.setImages(images);
        blog.setLocation(location);
        blog.setTags(tags);
        blog.setCreatedAt(new Date());
        return blog;
    }

    public Blog toUpdateBlog(){
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setDescription(description);
        blog.setImages(images);
        blog.setLocation(location);
        blog.setTags(tags);
        blog.setUpdatedAt(new Date());
        return blog;
    }
}
