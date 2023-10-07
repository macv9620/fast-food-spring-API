package com.macv.fastfood.persistence.repository;

import com.macv.fastfood.persistence.entity.OrderEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer> {
    List<OrderEntity> getAllByOrderDate(LocalDateTime date);
}
