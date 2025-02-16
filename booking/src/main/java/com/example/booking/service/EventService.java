package com.example.booking.service;

import com.example.booking.domain.dto.request.EventRequest;

import java.util.List;

public interface EventService {
    void createEvent(EventRequest eventRequest);
}
