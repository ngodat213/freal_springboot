package com.example.frealsb.Modules.Food.Service;

import com.example.frealsb.Modules.Food.FoodRepository;
import com.example.frealsb.Modules.Food.Model.Food;
import com.example.frealsb.Modules.Food.Request.RequestFood;
import com.example.frealsb.Util.Model.PaginationDTO;
import com.example.frealsb.Util.PaginationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FoodService implements IFoodService {
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private PaginationService paginationService;

    @Override
    public List<Food> getAll(PaginationDTO paginationDTO) {
        Pageable pageable = paginationService.getPageable(paginationDTO);
        return foodRepository.findAll(pageable).toList();
    }

    @Override
    public Food getFood(String id) {
        return foodRepository.findById(id).get();
    }

    @Override
    public Food addFood(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public Food updateFood(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public Food deleteFood(String id) {
        Food data = getFood(id);
        return foodRepository.save(data);
    }
}
