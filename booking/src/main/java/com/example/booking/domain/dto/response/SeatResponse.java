package com.example.booking.domain.dto.response;

public record SeatResponse(
        Long id,
        String number,
        boolean booked,
        String type,
        int price
) {
}
