package com.macv.fastfood.persistence.repository;

import com.macv.fastfood.persistence.entity.OrderEntity;
import com.macv.fastfood.persistence.projection.OrderSummary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer> {
    List<OrderEntity> getAllByOrderDate(LocalDateTime date);

    @Query(value = "SELECT po.id_order AS idOrder, cu.name AS customerName, po.date AS orderDate, " +
            "po.total AS orderTotal, STRING_AGG(pi.name, ', ') AS pizzaNames " +
            "FROM pizza_order po " +
            "JOIN customer cu ON po.id_customer = cu.id_customer " +
            "JOIN order_item oi ON po.id_order = oi.id_order " +
            "JOIN pizza pi ON oi.id_pizza = pi.id_pizza " +
            "WHERE po.id_order = :orderId " +
            "GROUP BY po.id_order, cu.name, po.date, po.total", nativeQuery = true)
    OrderSummary getOrderSummary(@Param("orderId") int orderId);
}
