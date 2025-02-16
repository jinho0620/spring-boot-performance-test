package com.example.booking.service.impl;

import com.example.booking.domain.dto.request.SlotRequest;
import com.example.booking.global.repository.SlotRepository;
import com.example.booking.service.SlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SlotServiceImpl implements SlotService {
    private final SlotRepository slotRepository;
    @Override
    public void createSlot(SlotRequest slotRequest) {
        slotRepository.save(slotRequest.toEntity());
    }
}
