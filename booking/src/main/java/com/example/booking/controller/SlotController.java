package com.example.booking.controller;

import com.example.booking.domain.dto.request.EventRequest;
import com.example.booking.domain.dto.request.SlotRequest;
import com.example.booking.service.EventService;
import com.example.booking.service.SlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/slots")
@RequiredArgsConstructor
public class SlotController {
    private final SlotService slotService;

    @PostMapping
    public void createSlot(@RequestBody SlotRequest slotRequest) {
        slotService.createSlot(slotRequest);
    }
}
