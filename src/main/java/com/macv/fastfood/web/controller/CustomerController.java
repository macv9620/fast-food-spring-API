package com.macv.fastfood.web.controller;

import com.macv.fastfood.persistence.entity.CustomerEntity;
import com.macv.fastfood.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CustomerEntity>> getAll(){
        return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getAllJpql")
    public ResponseEntity<List<CustomerEntity>> getAllJPQL(){
        return new ResponseEntity<>(customerService.getAllJPQL(), HttpStatus.OK);
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<CustomerEntity> getAllJPQL(@PathVariable String email){
        return new ResponseEntity<>(customerService.getAllByEmail(email), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<CustomerEntity> getById(@PathVariable String id){
        return new ResponseEntity<>(customerService.getById(id), HttpStatus.OK);
    }
}
