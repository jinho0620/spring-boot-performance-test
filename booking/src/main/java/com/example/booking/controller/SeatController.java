package com.example.booking.controller;

import com.example.booking.domain.dto.request.SeatRequest;
import com.example.booking.domain.dto.response.SeatResponse;
import com.example.booking.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/seats")
@RequiredArgsConstructor
public class SeatController {
    private final SeatService seatService;

    @PostMapping
    public void createSeat(@RequestBody SeatRequest seatRequest) {
        seatService.createSeat(seatRequest);
    }

    @GetMapping("/slot/{slotId}")
    public List<SeatResponse> getSeatsBySlotId(@PathVariable Long slotId) {
        return seatService.getSeatsBySlotId(slotId);
    }
}
