package com.example.frealsb.Modules.FoodCategory.Service;

import com.example.frealsb.Modules.FoodCategory.FoodCategoryRepository;
import com.example.frealsb.Modules.FoodCategory.Model.FoodCategory;
import com.example.frealsb.Modules.FoodCategory.Request.RequestFoodCategory;
import com.example.frealsb.Services.Interface.IFoodCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodCategoryService implements IFoodCategoryService {
    @Autowired
    private FoodCategoryRepository foodCategoryRepository;

    @Override
    public List<FoodCategory> getAllFoodCategory(String s, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return foodCategoryRepository.findAllBy(s, pageable);
    }

    @Override
    public FoodCategory getFoodCategory(String id) {
        return foodCategoryRepository.findById(id).get();
    }

    @Override
    public FoodCategory addFoodCategory(RequestFoodCategory req) {
        return foodCategoryRepository.save(req.toAddData());
    }

    @Override
    public FoodCategory updateFoodCategory(RequestFoodCategory req) {
        return foodCategoryRepository.save(req.toUpdateData());
    }

    @Override
    public FoodCategory deleteFoodCategory(String id) {
        FoodCategory foodCategory = getFoodCategory(id);
        return foodCategory;
    }
}
