package com.example.frealsb.Util.Model;

import com.example.frealsb.Common.AbstractEntity;
import com.example.frealsb.Modules.Post.Model.Post;
import com.example.frealsb.Modules.User.Model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ImageStorage extends AbstractEntity {
    public ImageStorage(String url, String assetId, String publicId){
        this.url = url;
        this.assetId = assetId;
        this.publicId = publicId;
    }

    public ImageStorage(String url, String assetId, String publicId, User user){
        this.url = url;
        this.assetId = assetId;
        this.publicId = publicId;
        this.user = user;
    }

    public ImageStorage(String url, String assetId, String publicId, Post post){
        this.url = url;
        this.assetId = assetId;
        this.publicId = publicId;
        this.post = post;
    }

    private String url;
    private String assetId;
    private String publicId;

    @OneToOne(mappedBy = "avatar")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "post_id")
    private Post post;
}