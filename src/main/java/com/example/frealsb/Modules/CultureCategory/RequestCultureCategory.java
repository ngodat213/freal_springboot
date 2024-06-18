package com.example.frealsb.Modules.CultureCategory;

import com.example.frealsb.Modules.CultureCategory.Model.CultureCategory;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class RequestCultureCategory {
    private String id;
    private String title;

    public CultureCategory toAddData(){
        CultureCategory data = new CultureCategory();
        data.setTitle(title);
        return data;
    }

    public CultureCategory toUpdateData(){
        CultureCategory data = new CultureCategory();
        data.setId(id);
        data.setTitle(title);
        return data;
    }
}
