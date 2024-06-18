package com.example.frealsb.Modules.Event.Service;

import com.example.frealsb.Modules.Event.Model.Event;
import com.example.frealsb.Modules.Event.EventRepository;
import com.example.frealsb.Modules.Event.RequestEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventService implements IEventService {
    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> getEvents(String s, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return eventRepository.findAllBy(s, pageable);
    }

    @Override
    public Event getEvent(String id) {
        return eventRepository.findById(id).get();
    }

    @Override
    public Event addEvent(RequestEvent req) {
        return eventRepository.save(req.toAddData());
    }

    @Override
    public Event saveEvent(RequestEvent req) {
        return eventRepository.save(req.toUpdateData());
    }

    @Override
    public Event deleteEvent(String id) {
        Event event = getEvent(id);
        event.setDeleted(true);
        return eventRepository.save(event);
    }
}
