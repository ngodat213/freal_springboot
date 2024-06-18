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
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Location extends AbstractEntity {
    private String city;
    private String province;
    private String features;

    // -- relationship --

    @OneToMany(mappedBy = "location")
    private List<Culture> cultureList;

    @OneToMany(mappedBy = "location")
    private List<FoodFeatured> foodFeaturedList;

    @OneToMany(mappedBy = "location")
    private List<Post> postList;
}
