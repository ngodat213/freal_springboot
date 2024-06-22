package com.example.frealsb.Modules.Location.Model;

import com.example.frealsb.Common.AbstractEntity;
import com.example.frealsb.Modules.Post.Model.Post;
import com.example.frealsb.Modules.Culture.Model.Culture;
import com.example.frealsb.Modules.FoodFeature.Model.FoodFeatured;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Location extends AbstractEntity {
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String province;
    @Column(nullable = false)
    private String features;

    // -- relationship --

    @OneToMany(mappedBy = "location")
    private List<Culture> cultureList;

    @OneToMany(mappedBy = "location")
    private List<FoodFeatured> foodFeaturedList;

    @OneToMany(mappedBy = "location")
    private List<Post> postList;
}
