package com.example.frealsb.Modules.FoodFeature.Service;

import com.example.frealsb.Modules.FoodFeature.FoodFeaturedRepository;
import com.example.frealsb.Modules.FoodFeature.Model.FoodFeatured;
import com.example.frealsb.Modules.FoodFeature.Request.RequestFoodFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodFeatureService implements IFoodFeatureService {
    @Autowired
    private FoodFeaturedRepository foodFeaturedRepository;

    @Override
    public List<FoodFeatured> getAllFoods(String s, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return foodFeaturedRepository.findAllBy(s, pageable);
    }

    @Override
    public FoodFeatured getFood(String id) {
        return foodFeaturedRepository.findById(id).get();
    }

    @Override
    public FoodFeatured addFood(RequestFoodFeature food) {
        return foodFeaturedRepository.save(food.toAddData());
    }

    @Override
    public FoodFeatured updateFood(RequestFoodFeature food) {
        return foodFeaturedRepository.save(food.toUpdateData());
    }

    @Override
    public FoodFeatured deleteFood(String id) {
        FoodFeatured data = getFood(id);
        return foodFeaturedRepository.save(data);
    }
}
