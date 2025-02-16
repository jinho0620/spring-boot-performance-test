package com.example.booking.domain.dto.request;

import com.example.booking.domain.entity.Event;
import com.example.booking.domain.entity.Slot;

import java.time.LocalDateTime;

public record SlotRequest(
        String location,
        String address,
        int totalSeats,
        LocalDateTime start_at,
        LocalDateTime end_at,
        Long eventId
) {
    public Slot toEntity() {
        Event event = Event.builder()
                .id(eventId)
                .build();

        Slot slot = Slot.builder()
                .location(location)
                .address(address)
                .totalSeats(totalSeats)
                .start_at(start_at)
                .end_at(end_at)
                .event(event)
                .build();
        return slot;
    }
}
