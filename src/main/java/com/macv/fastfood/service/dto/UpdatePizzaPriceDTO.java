package com.macv.fastfood.service.dto;

import java.util.Objects;

public class UpdatePizzaPriceDTO {
    private int pizzaId;
    private double newPrice;

    public UpdatePizzaPriceDTO(int pizzaId, double newPrice) {
        this.pizzaId = pizzaId;
        this.newPrice = newPrice;
    }

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdatePizzaPriceDTO that = (UpdatePizzaPriceDTO) o;
        return pizzaId == that.pizzaId && Double.compare(newPrice, that.newPrice) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pizzaId, newPrice);
    }

    @Override
    public String toString() {
        return "UpdatePizzaPriceDTO{" +
                "pizzaId=" + pizzaId +
                ", newPrice=" + newPrice +
                '}';
    }
}
