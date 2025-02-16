package com.example.booking.service.impl;

import com.example.booking.domain.dto.request.EventRequest;
import com.example.booking.domain.entity.Event;
import com.example.booking.global.repository.EventRepository;
import com.example.booking.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    // save()
    @Override
    public void createEvent(EventRequest eventRequest) {
        eventRepository.save(eventRequest.toEntity());
    }
}
