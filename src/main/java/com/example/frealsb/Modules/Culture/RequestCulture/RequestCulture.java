package com.example.frealsb.Modules.Culture.RequestCulture;

import com.example.frealsb.Modules.Culture.Model.Culture;
import com.example.frealsb.Modules.Location.Model.Location;
import lombok.*;

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
