package com.macv.fastfood.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "delivery_method")
public class DeliveryMethodEntity {
    @Id
    @Column(name = "id_method")
    Character methodId;

    String description;

    @Column(name = "active")
    Boolean isActive;

    public Character getMethodId() {
        return methodId;
    }

    public void setMethodId(Character methodId) {
        this.methodId = methodId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
