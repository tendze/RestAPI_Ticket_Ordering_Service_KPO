package com.dang.ticket_ordering_service.core.repository;

import com.dang.ticket_ordering_service.core.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Integer> {
    Order findById(int id);
}
