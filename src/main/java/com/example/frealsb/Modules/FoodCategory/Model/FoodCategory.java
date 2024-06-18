package com.example.frealsb.Modules.FoodCategory.Model;

import java.util.Date;

import com.example.frealsb.Common.AbstractEntity;
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
public class FoodCategory extends AbstractEntity {
    private String title;
}
