package com.dang.ticket_ordering_service.infastructure.service;

import com.dang.ticket_ordering_service.core.entity.Station;
import com.dang.ticket_ordering_service.core.repository.IStationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StationService {
    private final IStationRepository stationRepo;

    public Station findById(int id) {
        return stationRepo.findById(id);
    }
}
