package com.macv.fastfood.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
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
}
