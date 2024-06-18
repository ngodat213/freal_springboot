package com.example.frealsb.Modules.Food.Request;

import com.example.frealsb.Modules.Food.Model.Food;
import com.example.frealsb.Modules.FoodCategory.Model.FoodCategory;
import com.example.frealsb.Modules.FoodFeature.Model.FoodFeatured;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class RequestFood {
    private String id;
    private String title;
    private String description;
    private String location;
    private FoodFeatured foodFeatured;
    private FoodCategory foodCategory;
    private double price;
    private double rating;
    private String openingHours;
    private String contactNumber;

    public Food toAddData(){
        Food data = new Food();
        data.setTitle(title);
        data.setDescription(description);
        data.setLocation(location);
        data.setFoodFeatured(foodFeatured);
        data.setFoodCategory(foodCategory);
        data.setPrice(price);
        data.setRating(rating);
        data.setOpeningHours(openingHours);
        data.setContactNumber(contactNumber);
        return data;
    }

    public Food toUpdateData(){
        Food data = new Food();
        data.setId(id);
        data.setTitle(title);
        data.setDescription(description);
        data.setLocation(location);
        data.setFoodFeatured(foodFeatured);
        data.setFoodCategory(foodCategory);
        data.setPrice(price);
        data.setRating(rating);
        data.setOpeningHours(openingHours);
        data.setContactNumber(contactNumber);
        return data;
    }
}
