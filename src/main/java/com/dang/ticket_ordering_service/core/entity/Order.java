package com.dang.ticket_ordering_service.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@Entity
@Builder
@Table(name="`order`")
@RequiredArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int user_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_station_id", nullable = false)
    private Station from_station_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_station_id", nullable = false)
    private Station to_station_id;

    @Enumerated(EnumType.ORDINAL)
    private OrderStatus status;

    @Column(name = "created")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp created;
}