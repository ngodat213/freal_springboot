package com.example.frealsb.Modules.CultureCategory.Model;

import com.example.frealsb.Common.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class CultureCategory extends AbstractEntity {
    private String title;
}
