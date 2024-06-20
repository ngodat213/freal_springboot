package com.example.frealsb.Modules.Culture.Model;

import com.example.frealsb.Common.AbstractEntity;
import com.example.frealsb.Modules.Event.Model.Event;
import com.example.frealsb.Modules.Location.Model.Location;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Culture extends AbstractEntity {
    private String title;
    private String description;
    // -- Relationship --
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "culture")
    private List<Event> eventList;
}
