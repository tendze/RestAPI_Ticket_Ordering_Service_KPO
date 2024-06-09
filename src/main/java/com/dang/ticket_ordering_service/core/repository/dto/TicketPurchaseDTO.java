package com.dang.ticket_ordering_service.core.repository.dto;

import com.dang.ticket_ordering_service.core.entity.OrderStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TicketPurchaseDTO {
    int user_id;
    int from_station_id;
    int to_station_id;
    OrderStatus status = OrderStatus.CHECK;
}
