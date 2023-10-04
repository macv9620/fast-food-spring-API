package com.macv.fastfood.persistence.entity;

import jakarta.persistence.*;

@Entity
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

    public OrderItemPK getId() {
        return id;
    }

    public void setId(OrderItemPK id) {
        this.id = id;
    }

    public Integer getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Integer pizzaId) {
        this.pizzaId = pizzaId;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public PizzaEntity getPizza() {
        return pizza;
    }

    public void setPizza(PizzaEntity pizza) {
        this.pizza = pizza;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }
}
