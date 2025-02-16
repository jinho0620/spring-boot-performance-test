package com.example.booking.domain.dto.request;

import com.example.booking.domain.entity.Event;
import com.example.booking.domain.type.Category;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record EventRequest(
        String name,
        String description,
        Category category,
        LocalDate startAt,
        LocalDate endAt
) {
    public Event toEntity() {
        Event event = Event.builder()
                .name(name)
                .description(description)
                .category(category)
                .startAt(startAt)
                .endAt(endAt)
                .build();
        return event;
    }
}
