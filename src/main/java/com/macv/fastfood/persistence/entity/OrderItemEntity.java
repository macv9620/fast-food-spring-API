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
}
