package com.example.booking.service.impl;

import com.example.booking.domain.dto.request.SeatGradeRequest;
import com.example.booking.global.repository.SeatGradeRepository;
import com.example.booking.service.SeatGradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SeatGradeServiceImpl implements SeatGradeService {
    private final SeatGradeRepository seatGradeRepository;

    @Override
    public void createSeatGrade(SeatGradeRequest seatGradeRequest) {
        seatGradeRepository.save(seatGradeRequest.toEntity());
    }
}
