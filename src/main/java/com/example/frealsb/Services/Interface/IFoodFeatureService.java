package com.example.frealsb.Services.Interface;

import com.example.frealsb.Entities.FoodFeatured;
import com.example.frealsb.RequestEntities.RequestFoodFeature;

import java.util.List;

public interface IFoodFeatureService {
    List<FoodFeatured> getAllFoods(String s, int page, int size);
    FoodFeatured getFood(String id);
    FoodFeatured addFood(RequestFoodFeature food);
    FoodFeatured updateFood(RequestFoodFeature food);
    FoodFeatured deleteFood(String id);
}
