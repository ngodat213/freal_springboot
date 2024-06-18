package com.example.frealsb.Modules.Food.Model;

import com.example.frealsb.Common.AbstractEntity;
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
    private String foodFeaturedId;
    private String foodCategoryId;
    private double price;
    private double rating;
    private String openingHours;
    private String contactNumber;
}
