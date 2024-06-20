package com.example.frealsb.Modules.FoodFeature.Service;

import com.example.frealsb.Modules.FoodFeature.Model.FoodFeatured;
import com.example.frealsb.Modules.FoodFeature.Request.RequestFoodFeature;

import java.util.List;

public interface IFoodFeatureService {
    List<FoodFeatured> getAllFoods(String s, int page, int size);
    FoodFeatured getFood(String id);
    FoodFeatured addFood(RequestFoodFeature food);
    FoodFeatured updateFood(RequestFoodFeature food);
    FoodFeatured deleteFood(String id);
}