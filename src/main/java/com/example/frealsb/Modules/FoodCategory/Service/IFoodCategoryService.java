package com.example.frealsb.Modules.FoodCategory.Service;


import com.example.frealsb.Modules.FoodCategory.Model.FoodCategory;
import com.example.frealsb.Modules.FoodCategory.Request.RequestFoodCategory;

import java.util.List;

public interface IFoodCategoryService {
    // __CURD__ //
    List<FoodCategory> getAllFoodCategory(String s, int page, int size);
    FoodCategory getFoodCategory(String id);
    FoodCategory addFoodCategory(RequestFoodCategory req);
    FoodCategory updateFoodCategory(RequestFoodCategory req);
    FoodCategory deleteFoodCategory(String id);
}