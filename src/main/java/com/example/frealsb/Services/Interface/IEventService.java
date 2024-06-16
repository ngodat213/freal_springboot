package com.example.frealsb.Services.Interface;

import com.example.frealsb.Entities.Event;
import com.example.frealsb.RequestEntities.RequestEvent;

import java.util.List;

public interface IEventService {
    // __CURD__ //
    List<Event> getEvents(String s, int page, int size);
    Event getEvent(String id);
    Event addEvent(RequestEvent req);
    Event saveEvent(RequestEvent req);
    Event deleteEvent(String id);
}
