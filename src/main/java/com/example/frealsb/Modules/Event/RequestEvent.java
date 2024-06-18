package com.example.frealsb.Modules.Event;

import com.example.frealsb.Modules.Culture.Model.Culture;
import com.example.frealsb.Modules.Event.Model.Event;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class RequestEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String title;
    private Date timeStart;
    private Date timeEnd;
    private EventStatus status;
    private Culture culture;
    private String locationDetail;
    private String contactNumber;
    private String openingHours;
    private String mapAddress;
    private double ticketPrice;

    public Event toAddData(){
        Event event = new Event();
        event.setTitle(title);
        event.setTimeStart(timeStart);
        event.setTimeEnd(timeEnd);
        event.setTimeStart(timeStart);
        event.setTimeEnd(timeEnd);
        event.setStatus(status.name());
        event.setCulture(culture);
        event.setLocationDetail(locationDetail);
        event.setContactNumber(contactNumber);
        event.setOpeningHours(openingHours);
        event.setMapAddress(mapAddress);
        event.setTicketPrice(ticketPrice);
        return event;
    }

    public Event toUpdateData(){
        Event event = new Event();
        event.setId(id);
        event.setTitle(title);
        event.setTimeStart(timeStart);
        event.setTimeEnd(timeEnd);
        event.setTimeStart(timeStart);
        event.setTimeEnd(timeEnd);
        event.setStatus(status.name());
        event.setCulture(culture);
        event.setLocationDetail(locationDetail);
        event.setContactNumber(contactNumber);
        event.setOpeningHours(openingHours);
        event.setMapAddress(mapAddress);
        event.setTicketPrice(ticketPrice);
        return event;
    }

    public enum EventStatus{
        AVAILABLE,   // Còn khả dụng
        RESERVED,    // Đã đặt trước
        SOLD,        // Đã bán
        CANCELLED,   // Đã hủy
        EXPIRED,     // Đã hết hạn
        CHECKED_IN,  // Đã check-in
        PENDING
    }
}
