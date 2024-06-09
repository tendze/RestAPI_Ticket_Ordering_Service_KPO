package com.dang.ticket_ordering_service.infastructure.service;

import com.dang.ticket_ordering_service.core.entity.Order;
import com.dang.ticket_ordering_service.core.repository.IOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final IOrderRepository orderRepo;

    public Order saveOrder(Order order) {
        return orderRepo.save(order);
    }

    public Order findOrderById(int id) {
        return orderRepo.findById(id);
    }
}
