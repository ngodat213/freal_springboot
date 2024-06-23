package com.example.frealsb.Modules.Food.Service;

import com.example.frealsb.Modules.Food.Model.Food;
import com.example.frealsb.Modules.Food.Request.RequestFood;
import com.example.frealsb.Util.Model.PaginationDTO;

import java.util.List;

public interface IFoodService {
    List<Food> getAll(PaginationDTO paginationDTO);
    Food getFood(String id);
    Food addFood(Food food);
    Food updateFood(Food food);
    Food deleteFood(String id);
}