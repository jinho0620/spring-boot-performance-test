package com.example.booking.service.impl;

import com.example.booking.domain.dto.request.SeatRequest;
import com.example.booking.domain.dto.response.SeatResponse;
import com.example.booking.domain.entity.Seat;
import com.example.booking.global.repository.SeatRepository;
import com.example.booking.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SeatServiceImpl implements SeatService {
    private final SeatRepository seatRepository;
    private final JdbcTemplate jdbcTemplate;

    // save
    @Override
    public void createSeat(SeatRequest seatRequest) {
        seatRepository.save(seatRequest.toEntity());
    }

    // saveAll()
    @Override
    public void createSeats(List<SeatRequest> seatRequests) {
        List<Seat> seats = seatRequests.stream().map(SeatRequest::toEntity).toList();
        seatRepository.saveAll(seats);
    }

    // batchUpdate() - JdbcTemplate
    @Override
    public void batchCreateSeats(List<SeatRequest> seatRequests) {
        String sql = "INSERT INTO seats (number, booked, slot_Id, seat_grade_id) VALUES (?, ?, ?, ?)";
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                SeatRequest seatRequest = seatRequests.get(i);
                ps.setString(1, seatRequest.number());
                ps.setBoolean(2, false);
                ps.setLong(3, seatRequest.slotId());
                ps.setLong(4, seatRequest.seatGradeId());
            }

            @Override
            public int getBatchSize() {
                return seatRequests.size();
            }
        });
    }

    @Override
    public List<SeatResponse> getSeatsBySlotId(Long slotId) {
        List<Seat> seats = seatRepository.findBySlotId(slotId);
        List<SeatResponse> res = seats.stream().map(seat ->
                new SeatResponse(
                    seat.getId(),
                    seat.getNumber(),
                    seat.isBooked(),
                    seat.getSeatGrade().getType(),
                    seat.getSeatGrade().getPrice()
        )).toList();
        return res;
    }
}
