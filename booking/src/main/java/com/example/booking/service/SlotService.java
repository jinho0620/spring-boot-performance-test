package com.example.booking.service;

import com.example.booking.domain.dto.request.EventRequest;
import com.example.booking.domain.dto.request.SlotRequest;

public interface SlotService {
    void createSlot(SlotRequest slotRequest);
}
