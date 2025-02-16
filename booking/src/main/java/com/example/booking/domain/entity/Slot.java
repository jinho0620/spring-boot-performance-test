package com.example.booking.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SLOTS")
@Builder
public class Slot {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "TOTAL_SEATS")
    private int totalSeats;

    @Column(name = "RESERVED_SEATS")
    @Builder.Default
    private int reservedSeats = 0;

    @Column(name = "START_AT")
    private LocalDateTime start_at;

    @Column(name = "END_AT")
    private LocalDateTime end_at;

    @JoinColumn(name = "EVENT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Event event;
}
