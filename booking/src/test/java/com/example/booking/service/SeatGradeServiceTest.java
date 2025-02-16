package com.example.booking.service;

import com.example.booking.domain.dto.request.SeatGradeRequest;
import com.example.booking.domain.entity.SeatGrade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SeatGradeServiceTest {
    @Autowired
    private SeatGradeService seatGradeService;

    @Test
    void createSeatGrade() {
        SeatGradeRequest req1 = new SeatGradeRequest("VIP", 150000);
        SeatGradeRequest req2 = new SeatGradeRequest("A", 130000);
        SeatGradeRequest req3 = new SeatGradeRequest("B", 100000);
        SeatGradeRequest req4 = new SeatGradeRequest("C", 88000);
        SeatGradeRequest req5 = new SeatGradeRequest("D", 50000);

        List<SeatGradeRequest> seatGrades = Arrays.asList(req1, req2, req3, req4, req5);

        seatGrades.forEach(grade -> seatGradeService.createSeatGrade(grade));
    }
}