package com.example.booking.controller;

import com.example.booking.domain.dto.request.SeatGradeRequest;
import com.example.booking.domain.dto.request.SlotRequest;
import com.example.booking.service.SeatGradeService;
import com.example.booking.service.SlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/seat-grades")
@RequiredArgsConstructor
public class SeatGradeController {
    private final SeatGradeService seatGradeService;

    @PostMapping
    public void createSeatGrade(@RequestBody SeatGradeRequest seatGradeRequest) {
        seatGradeService.createSeatGrade(seatGradeRequest);
    }
}
