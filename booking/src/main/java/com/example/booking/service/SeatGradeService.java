package com.example.booking.service;

import com.example.booking.domain.dto.request.SeatGradeRequest;

import java.util.List;

public interface SeatGradeService {
    void createSeatGrade(SeatGradeRequest seatGradeRequest);
}
