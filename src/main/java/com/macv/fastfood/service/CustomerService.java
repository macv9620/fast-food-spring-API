package com.macv.fastfood.service;

import com.macv.fastfood.persistence.entity.CustomerEntity;
import com.macv.fastfood.persistence.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerEntity> getAll(){
        return customerRepository.findAll();
    }

    public List<CustomerEntity> getAllJPQL(){
        return customerRepository.getAllCustomers();
    }

    public CustomerEntity getAllByEmail(String email){
        return customerRepository.getByEmail(email);
    }

    public CustomerEntity getById(String id){
        return customerRepository.getById(id);
    }
}
