package com.example.frealsb.RequestEntities;

import com.example.frealsb.Entities.CultureCategory;
import com.example.frealsb.Entities.FoodCategory;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class RequestFoodCategory {
    private String id;
    private String title;

    public FoodCategory toAddData(){
        FoodCategory data = new FoodCategory();
        data.setTitle(title);
        data.setCreatedAt(new Date());
        return data;
    }

    public FoodCategory toUpdateData(){
        FoodCategory data = new FoodCategory();
        data.setId(id);
        data.setTitle(title);
        data.setUpdatedAt(new Date());
        return data;
    }
}
