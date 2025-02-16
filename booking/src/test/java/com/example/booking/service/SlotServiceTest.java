package com.example.booking.service;

import com.example.booking.domain.dto.request.SlotRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SlotServiceTest {
    @Autowired
    private SlotService slotService;

    @Test
    void createSlot() {
        for (int month = 11; month <= 15; month++) {
            SlotRequest slotRequest = new SlotRequest(
                    "상암 월드컵 경기장",
                    "상암역",
                    35000,
                    LocalDateTime.of(2025, Month.JANUARY, month, 15, 0),
                    LocalDateTime.of(2025, Month.JANUARY, month, 18, 0),
                    2L
            );

            slotService.createSlot(slotRequest);
        }
    }
}