package com.example.frealsb.Services.Interface;

import com.example.frealsb.Entities.Food;
import com.example.frealsb.Entities.FoodFeatured;
import com.example.frealsb.RequestEntities.RequestFood;
import com.example.frealsb.RequestEntities.RequestFoodFeature;

import java.util.List;

public interface IFoodService {
    List<Food> getAllFoods(String s, int page, int size);
    Food getFood(String id);
    Food addFood(RequestFood req);
    Food updateFood(RequestFood req);
    Food deleteFood(String id);
}
