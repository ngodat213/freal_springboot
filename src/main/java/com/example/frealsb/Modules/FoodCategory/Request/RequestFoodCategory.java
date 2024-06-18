package com.example.frealsb.Modules.FoodCategory.Request;

import com.example.frealsb.Modules.FoodCategory.Model.FoodCategory;
import lombok.*;

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
        return data;
    }

    public FoodCategory toUpdateData(){
        FoodCategory data = new FoodCategory();
        data.setId(id);
        data.setTitle(title);
        return data;
    }
}
