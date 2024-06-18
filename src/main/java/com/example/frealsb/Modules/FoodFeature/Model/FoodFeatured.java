package com.example.frealsb.Modules.FoodFeature.Model;

import java.util.Date;

import com.example.frealsb.Common.AbstractEntity;
import com.example.frealsb.Modules.Location.Model.Location;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class FoodFeatured extends AbstractEntity {
    private String title;
    private String description;

    // -- Relationships --
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
}
