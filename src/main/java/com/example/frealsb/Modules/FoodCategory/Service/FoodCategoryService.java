package com.example.frealsb.Modules.FoodCategory.Service;

import com.example.frealsb.Modules.FoodCategory.FoodCategoryRepository;
import com.example.frealsb.Modules.FoodCategory.Model.FoodCategory;
import com.example.frealsb.Modules.FoodCategory.Request.RequestFoodCategory;
import com.example.frealsb.Util.Model.PaginationDTO;
import com.example.frealsb.Util.PaginationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodCategoryService implements IFoodCategoryService {
    @Autowired
    private FoodCategoryRepository foodCategoryRepository;
    @Autowired
    private PaginationService paginationService;

    @Override
    public List<FoodCategory> getAll(PaginationDTO paginationDTO) {
        Pageable pageable = paginationService.getPageable(paginationDTO);
        return foodCategoryRepository.findAll(pageable).toList();
    }

    @Override
    public FoodCategory getFoodCategory(String id) {
        return foodCategoryRepository.findById(id).get();
    }

    @Override
    public FoodCategory addFoodCategory(FoodCategory foodCategory) {
        return foodCategoryRepository.save(foodCategory);
    }

    @Override
    public FoodCategory updateFoodCategory(FoodCategory foodCategory) {
        return foodCategoryRepository.save(foodCategory);
    }

    @Override
    public FoodCategory deleteFoodCategory(String id) {
        FoodCategory foodCategory = getFoodCategory(id);
        return foodCategory;
    }
}
