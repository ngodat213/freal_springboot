package com.example.frealsb.Modules.Post.Request;

import com.example.frealsb.Modules.Post.Model.Post;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestPost {
    private String title;
    private MultipartFile[] imageFiles;

    public Post toAddData(){
        Post data = new Post();
        data.setTitle(title);
        return data;
    }

    public Post toUpdateData(){
        Post data = new Post();
        data.setTitle(title);
        return data;
    }
}
