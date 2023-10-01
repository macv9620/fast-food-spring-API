package com.macv.fastfood.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="customer")
public class Customer {
    @Id
    @Column(name = "id_customer")
    private String customerId;

    private String name;

    private String address;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;
}
