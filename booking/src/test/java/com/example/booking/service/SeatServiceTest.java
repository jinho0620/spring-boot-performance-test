package com.example.booking.service;

import com.example.booking.domain.dto.request.SeatRequest;
import com.example.booking.domain.dto.response.SeatResponse;
import com.example.booking.domain.entity.Seat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SeatServiceTest {

    @Autowired
    private SeatService seatService;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final Long SLOT_ID = 1L;
    private final String[] grades = {"VIP", "A", "B", "C", "D"};
    private final Long[] seatGradeIds = {1L, 2L, 3L, 4L, 5L};
    private final int[] seatCounts = {5_000, 10_000, 10_000, 10_000, 15_000};

    List<SeatRequest> combineSeats() {
        List<SeatRequest> seats = new ArrayList<>();
        for (int i = 0; i < seatCounts.length; i++) {
            for (int j = 1; j <= seatCounts[i]; j++) {
                String seatNumber = grades[i] + j;
                SeatRequest seatRequest = new SeatRequest(seatNumber, SLOT_ID, seatGradeIds[i]);
                seats.add(seatRequest);
            }
        }
        return seats;
    }


    @Test
    void createSeat() {
        // Seat 50,000 (VIP: 5,000, A: 10,000, B: 10,000, C: 10,000, D: 15,000)개 넣기 @같은 slot
        long before = System.currentTimeMillis();
        for (int i = 0; i < seatCounts.length; i++) {
            for (int j = 1; j <= seatCounts[i]; j++) {
                String seatNumber = grades[i] + j;
                SeatRequest seatRequest = new SeatRequest(seatNumber, SLOT_ID, seatGradeIds[i]);
                seatService.createSeat(seatRequest);
            }
        }
        long after = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (after - before));
    }

    @Test
    void createSeats() {
        List<SeatRequest> seatRequests = combineSeats();
        long before = System.currentTimeMillis();
        seatService.createSeats(seatRequests);
        long after = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (after - before));
    }

    @Test
    void batchCreateSeats() {
        List<SeatRequest> seatRequests = combineSeats();
        long before = System.currentTimeMillis();
        seatService.batchCreateSeats(seatRequests);
        long after = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (after - before));
    }

    @Test
    void getSeatsBySlotId() {
        long before = System.currentTimeMillis();
        List<SeatResponse> res = seatService.getSeatsBySlotId(SLOT_ID);
        System.out.println(res.size());
        long after = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (after - before));
    }
}