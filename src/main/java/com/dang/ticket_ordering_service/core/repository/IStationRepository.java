package com.dang.ticket_ordering_service.core.repository;

import com.dang.ticket_ordering_service.core.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStationRepository extends JpaRepository<Station, Integer> {
    Station findById(int id);
}
