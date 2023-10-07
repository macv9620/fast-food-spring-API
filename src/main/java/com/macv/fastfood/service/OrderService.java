package com.macv.fastfood.service;

import com.macv.fastfood.persistence.entity.OrderEntity;
import com.macv.fastfood.persistence.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public List<OrderEntity> getAll(){
        return orderRepository.findAll();
    }

    public List<OrderEntity> getTodayOrders(){
        LocalDateTime date = LocalDateTime.now();
        return orderRepository.getAllByOrderDate(date);
    }

    public OrderEntity save(OrderEntity order){
        return orderRepository.save(order);
    }
}
