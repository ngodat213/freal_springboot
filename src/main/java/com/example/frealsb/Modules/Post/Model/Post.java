package com.example.frealsb.Modules.Post.Model;

import com.example.frealsb.Common.AbstractEntity;
import com.example.frealsb.Modules.Tag.Model.Tag;
import com.example.frealsb.Modules.User.Model.User;
import com.example.frealsb.Modules.Comment.Model.Comment;
import com.example.frealsb.Modules.Location.Model.Location;
import com.example.frealsb.Util.Model.ImageStorage;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Post extends AbstractEntity {
    @Min(0)
    private int fav = 0;

    @Column(nullable = true)
    private String title;

    @OneToMany(mappedBy = "post")
    private List<ImageStorage> images;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "posts_tags",
            joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
    @OrderBy("name ASC")
    private Collection<Tag> tags = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.EXTRA)
    @OrderBy("createdAt ASC")
    private List<Comment> comments = new ArrayList<>();

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "location_id")
    private Location location;
//
//    @ManyToOne()
//    @JoinColumn(name = "event_id")
//    private Event event;
//
//    @ManyToOne()
//    @JoinColumn(name = "food_id")
//    private Food food;

    private String video;
}
