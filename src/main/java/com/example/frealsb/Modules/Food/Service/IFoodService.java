package com.example.frealsb.Modules.Food.Service;

import com.example.frealsb.Modules.Food.Model.Food;
import com.example.frealsb.Modules.Food.Request.RequestFood;

import java.util.List;

public interface IFoodService {
    List<Food> getAllFoods(String s, int page, int size);
    Food getFood(String id);
    Food addFood(RequestFood req);
    Food updateFood(RequestFood req);
    Food deleteFood(String id);
}