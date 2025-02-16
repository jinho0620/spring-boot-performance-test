package com.example.booking.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SEATS")
@Builder
public class Seat {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NUMBER")
    private String number;

    @Column(name = "BOOKED")
    @Builder.Default
    private boolean booked = false;

    @JoinColumn(name = "SLOT_ID")
    @ManyToOne(optional = false)
    private Slot slot;

    @JoinColumn(name = "SEAT_GRADE_ID")
    @ManyToOne
    private SeatGrade seatGrade;
}
