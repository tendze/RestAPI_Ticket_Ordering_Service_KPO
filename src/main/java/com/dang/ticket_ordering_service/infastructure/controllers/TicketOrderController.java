package com.dang.ticket_ordering_service.infastructure.controllers;

import com.dang.ticket_ordering_service.core.entity.Order;
import com.dang.ticket_ordering_service.core.entity.OrderStatus;
import com.dang.ticket_ordering_service.core.entity.Station;
import com.dang.ticket_ordering_service.core.repository.dto.OrderInfoRequestDTO;
import com.dang.ticket_ordering_service.core.repository.dto.OrderInfoResponseDTO;
import com.dang.ticket_ordering_service.core.repository.dto.TicketPurchaseDTO;
import com.dang.ticket_ordering_service.infastructure.service.AuthService;
import com.dang.ticket_ordering_service.infastructure.service.OrderService;
import com.dang.ticket_ordering_service.infastructure.service.StationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TicketOrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private StationService stationService;
    @Autowired
    private AuthService authService;

    @PostMapping("/ticketPurchase")
    public ResponseEntity<?> ticketPurchase(@RequestHeader("Authorization") String jwtToken, @RequestBody TicketPurchaseDTO ticketPurchaseDTO) {
        jwtToken = jwtToken.substring(7);
        int userId = authService.getUserId(jwtToken);

        Station fromStation = stationService.findById(ticketPurchaseDTO.getFrom_station_id());
        Station toStation = stationService.findById(ticketPurchaseDTO.getTo_station_id());

        if (fromStation == null || toStation == null) {
            return new ResponseEntity<>(
                    String.format("Stations with id's %d or %d not found", ticketPurchaseDTO.getFrom_station_id(), ticketPurchaseDTO.getTo_station_id()),
                    HttpStatus.NOT_FOUND
            );
        }

        try {
            orderService.saveOrder(
                    Order.builder()
                            .user_id(userId)
                            .from_station_id(fromStation)
                            .to_station_id(toStation)
                            .status(OrderStatus.CHECK)
                            .build()
            );
            return ResponseEntity.ok("Order created.");
        } catch (Exception e) {
            return new ResponseEntity<>("Exception occurred: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getOrderInfo")
    public ResponseEntity<?> getOrderInfo(@RequestBody OrderInfoRequestDTO orderInfoRequestDTO) {
        Order order = orderService.findOrderById(orderInfoRequestDTO.getId());
        if (order == null) {
            return new ResponseEntity<>(String.format("Order with id %d was not found", orderInfoRequestDTO.getId()), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(
                new OrderInfoResponseDTO(
                        order.getId(),
                        order.getUser_id(),
                        order.getFrom_station_id().getId(),
                        order.getTo_station_id().getId(),
                        order.getCreated()
                )
        );
    }
}
