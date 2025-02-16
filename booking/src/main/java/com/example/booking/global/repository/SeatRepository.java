package com.example.booking.global.repository;

import com.example.booking.domain.entity.Seat;
import com.example.booking.domain.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findBySlotId(Long slotId);
}
