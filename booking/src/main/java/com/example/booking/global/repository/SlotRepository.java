package com.example.booking.global.repository;

import com.example.booking.domain.entity.Event;
import com.example.booking.domain.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlotRepository extends JpaRepository<Slot, Long> {
}
