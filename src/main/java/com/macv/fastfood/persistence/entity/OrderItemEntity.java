package com.macv.fastfood.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "order_item")
public class OrderItemEntity {
    @EmbeddedId
    private OrderItemPK id;

    @Column(name = "id_pizza")
    private Integer pizzaId;

    private Double quantity;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "id_pizza", referencedColumnName = "id_pizza",
            insertable = false, updatable = false)
    private PizzaEntity pizza;

    @ManyToOne
    @JoinColumn(name = "id.id_order", referencedColumnName = "id_order",
    insertable = false, updatable = false)
    private OrderEntity order;
}
