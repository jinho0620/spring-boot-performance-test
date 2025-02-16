package com.example.booking.service;

import com.example.booking.domain.dto.request.EventRequest;
import com.example.booking.domain.dto.request.SeatRequest;
import com.example.booking.domain.dto.response.SeatResponse;
import com.example.booking.domain.entity.Seat;

import java.util.List;

public interface SeatService {
    void createSeat(SeatRequest seatRequest);
    void createSeats(List<SeatRequest> seatRequests);
    void batchCreateSeats(List<SeatRequest> seatRequests);

    List<SeatResponse> getSeatsBySlotId(Long slotId);
}
