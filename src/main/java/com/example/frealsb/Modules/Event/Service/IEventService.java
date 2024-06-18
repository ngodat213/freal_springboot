package com.example.frealsb.Modules.Event.Service;

import com.example.frealsb.Modules.Event.Model.Event;
import com.example.frealsb.Modules.Event.RequestEvent;

import java.util.List;

public interface IEventService {
    // __CURD__ //
    List<Event> getEvents(String s, int page, int size);
    Event getEvent(String id);
    Event addEvent(RequestEvent req);
    Event saveEvent(RequestEvent req);
    Event deleteEvent(String id);
}
