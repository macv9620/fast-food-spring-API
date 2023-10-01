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
@Table(name="customer")
public class CustomerEntity {
    @Id
    @Column(name = "id_customer")
    private String customerId;

    private String name;

    private String address;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;
}
