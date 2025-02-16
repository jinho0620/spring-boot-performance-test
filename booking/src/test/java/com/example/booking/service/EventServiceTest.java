package com.example.booking.service;

import com.example.booking.domain.dto.request.EventRequest;
import com.example.booking.domain.type.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;


@SpringBootTest
class EventServiceTest {
    @Autowired
    private EventService eventService;

    @Test
    void createEvent() {
        EventRequest eventRequest = new EventRequest(
                "손흥민 직관경기",
                "손흥민 보러오세요.",
                Category.SPORTS,
                LocalDate.of(2025, Month.JANUARY, 11),
                LocalDate.of(2025, Month.JANUARY, 15)
        );
        eventService.createEvent(eventRequest);
    }
}