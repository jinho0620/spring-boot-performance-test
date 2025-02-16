package com.example.booking.domain.dto.request;

import com.example.booking.domain.entity.SeatGrade;

public record SeatGradeRequest(
        String type,
        int price
) {
    public SeatGrade toEntity() {
        SeatGrade seatGrade = SeatGrade.builder()
                .type(type)
                .price(price)
                .build();

        return seatGrade;
    }
}
