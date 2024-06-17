package com.example.frealsb.Modules.Event.Model;

import com.example.frealsb.Common.AbstractEntity;
import com.example.frealsb.Modules.Culture.Model.Culture;
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
public class Event extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = true)
    private String title;
    @Column(nullable = true)
    private Date timeStart;
    @Column(nullable = true)
    private Date timeEnd;
    @Column(nullable = true)
    private String status;
    @ManyToOne
    @JoinColumn(name = "culture_id")
    private Culture culture;
    @Column(nullable = true)
    private String locationDetail;
    @Column(nullable = true)
    private String contactNumber;
    @Column(nullable = true)
    private String openingHours;
    @Column(nullable = true)
    private String mapAddress;
    @Column(nullable = true)
    private double ticketPrice;
}
