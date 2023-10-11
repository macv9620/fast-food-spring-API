package com.macv.fastfood.service.dto;

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

}
