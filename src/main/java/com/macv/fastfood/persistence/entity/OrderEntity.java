package com.macv.fastfood.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "pizza_order")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Integer orderId;

    @Column(name = "id_customer")
    private String customerId;

    @Column(name = "date")
    private LocalDateTime orderDate;

    @Column(name = "total")
    private Double orderTotal;

    @Column(name = "id_method")
    private String methodId;

    private String comments;

    @OneToMany(mappedBy = "order")
    private List<OrderItemEntity> orderItems;

    @ManyToOne
    @JoinColumn(name = "id_customer", referencedColumnName = "id_customer", insertable = false,
    updatable = false)
    private CustomerEntity customer;
}
