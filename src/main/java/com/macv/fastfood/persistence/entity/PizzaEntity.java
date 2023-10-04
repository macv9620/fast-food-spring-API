package com.macv.fastfood.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pizza")
public class PizzaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pizza")
    private Integer pizzaId;


    private String name;
    private String description;
    private Double price;

    @Column(name = "vegetarian")
    private Boolean isVegetarian;

    @Column(name = "vegan")
    private Boolean isVegan;

    @Column(name = "available")
    private Boolean isAvailable;

    public Integer getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Integer id_pizza) {
        this.pizzaId = id_pizza;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getIsVegetarian() {
        return isVegetarian;
    }

    public void setIsVegetarian(Boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public Boolean getIsVegan() {
        return isVegan;
    }

    public void setIsVegan(Boolean vegan) {
        isVegan = vegan;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "pizzaId: " + this.pizzaId +
                " - name: " + this.name +
                " - description: " + this.description +
                " - price: " + this.price +
                " - isVegetarian: " + this.isVegetarian +
                " - isVegan: " + this.isVegan +
                " - isAvailable: " + this.isAvailable;
    }
}
