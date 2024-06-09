package com.dang.ticket_ordering_service.core.repository.dto;

import com.dang.ticket_ordering_service.core.entity.Station;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderInfoResponseDTO {
    int id;
    int user_id;
    int from_station_id;
    int to_station_id;
    Timestamp created;
}
