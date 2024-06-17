package com.example.frealsb.Services.Interface;

import com.example.frealsb.Entities.CultureCategory;
import com.example.frealsb.Entities.FoodCategory;
import com.example.frealsb.RequestEntities.RequestCultureCategory;
import com.example.frealsb.RequestEntities.RequestFoodCategory;

import java.util.List;

public interface IFoodCategoryService {
    // __CURD__ //
    List<FoodCategory> getAllFoodCategory(String s, int page, int size);
    FoodCategory getFoodCategory(String id);
    FoodCategory addFoodCategory(RequestFoodCategory req);
    FoodCategory updateFoodCategory(RequestFoodCategory req);
    FoodCategory deleteFoodCategory(String id);
}
