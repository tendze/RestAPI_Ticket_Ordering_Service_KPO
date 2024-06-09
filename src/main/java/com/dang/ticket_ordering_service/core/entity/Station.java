package com.dang.ticket_ordering_service.core.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "station")
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="station", nullable = false)
    @Size(min=1, max=50)
    private String station;
}
