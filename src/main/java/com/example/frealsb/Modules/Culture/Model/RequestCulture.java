package com.example.frealsb.Modules.Culture.Model;

import com.example.frealsb.Modules.Location.Model.Location;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class RequestCulture {
    private String id;
    private String title;
    private String description;
    private Location location;

    public Culture toAddData(){
        Culture culture = new Culture();
        culture.setTitle(title);
        culture.setDescription(description);
        culture.setLocation(location);
        return culture;
    }

    public Culture toUpdateData(){
        Culture culture = new Culture();
        culture.setId(id);
        culture.setTitle(title);
        culture.setDescription(description);
        culture.setLocation(location);
        return culture;
    }
}
