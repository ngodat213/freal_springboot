package com.example.frealsb.Modules.FoodCategory.Service;


import com.example.frealsb.Modules.FoodCategory.Model.FoodCategory;
import com.example.frealsb.Modules.FoodCategory.Request.RequestFoodCategory;
import com.example.frealsb.Util.Model.PaginationDTO;

import java.util.List;

public interface IFoodCategoryService {
    // __CURD__ //
    List<FoodCategory> getAll(PaginationDTO paginationDTO);
    FoodCategory getFoodCategory(String id);
    FoodCategory addFoodCategory(FoodCategory foodCategory);
    FoodCategory updateFoodCategory(FoodCategory foodCategory);
    FoodCategory deleteFoodCategory(String id);
}