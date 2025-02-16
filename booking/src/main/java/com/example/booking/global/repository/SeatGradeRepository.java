package com.example.booking.global.repository;

import com.example.booking.domain.entity.SeatGrade;
import com.example.booking.domain.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatGradeRepository extends JpaRepository<SeatGrade, Long> {
}
