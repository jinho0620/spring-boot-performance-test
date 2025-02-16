package com.example.booking.domain.dto.request;

import com.example.booking.domain.entity.Seat;
import com.example.booking.domain.entity.SeatGrade;
import com.example.booking.domain.entity.Slot;

public record SeatRequest(
        String number,
        Long slotId,
        Long seatGradeId
) {
    public Seat toEntity() {
        Slot slot = Slot.builder()
                .id(slotId)
                .build();

        SeatGrade seatGrade = SeatGrade.builder()
                .id(seatGradeId)
                .build();

        Seat seat = Seat.builder()
                .number(number)
                .slot(slot)
                .seatGrade(seatGrade)
                .build();

        return seat;
    }
}
