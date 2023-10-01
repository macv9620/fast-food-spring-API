package com.macv.fastfood.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "delivery_method")
public class DeliveryMethodEntity {
    @Id
    @Column(name = "id_method")
    Character methodId;

    String description;

    @Column(name = "active")
    Boolean isActive;
}
