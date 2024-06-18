package com.example.frealsb.Util.Model;

import com.example.frealsb.Common.AbstractEntity;
import com.example.frealsb.Modules.Blog.Model.Blog;
import com.example.frealsb.Modules.Event.Model.Event;
import com.example.frealsb.Modules.Location.Model.Location;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "product_image")
public class PImage extends AbstractEntity {

    private String url;
    private String assetId;
    private String publicId;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
}