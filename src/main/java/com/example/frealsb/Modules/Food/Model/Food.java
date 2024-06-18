package com.example.frealsb.Modules.Food.Model;

import com.example.frealsb.Common.AbstractEntity;
import com.example.frealsb.Modules.FoodCategory.Model.FoodCategory;
import com.example.frealsb.Modules.FoodFeature.Model.FoodFeatured;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Food extends AbstractEntity {
    private String title;
    private String description;
    private String location;
    @ManyToOne
    @JoinColumn(name = "food_featured_id")
    private FoodFeatured foodFeatured;
    @ManyToOne
    @JoinColumn(name = "food_category_id")
    private FoodCategory foodCategory;
    private double price;
    private double rating;
    private String openingHours;
    private String contactNumber;
}
