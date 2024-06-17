package com.example.frealsb.Modules.Blog;

import com.example.frealsb.Modules.Blog.Model.Blog;
import com.example.frealsb.Modules.Tag.Model.Tag;
import com.example.frealsb.Modules.User.Model.User;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestBlog {
    private String id;
    private String title;
    private String description;
    private String images;
    private String location;
    private List<Tag> tags;

    public Blog toAddData(User user){
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

    public Blog toUpdateData(){
        Blog blog = new Blog();
        blog.setId(id);
        blog.setTitle(title);
        blog.setDescription(description);
        blog.setImages(images);
        blog.setLocation(location);
        blog.setTags(tags);
        blog.setUpdatedAt(new Date());
        return blog;
    }
}
