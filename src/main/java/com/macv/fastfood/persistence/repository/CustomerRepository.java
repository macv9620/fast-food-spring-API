package com.macv.fastfood.persistence.repository;

import com.macv.fastfood.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends ListCrudRepository<CustomerEntity, String> {

    @Query(value = "SELECT c FROM CustomerEntity c")
    List<CustomerEntity> getAllCustomers();

    @Query(value = "SELECT c FROM CustomerEntity c WHERE c.email = :userEmail")
    CustomerEntity getByEmail(@Param("userEmail") String userEmail);

    //Query nativo
    @Query(value = "SELECT * FROM customer c WHERE c.id_customer = :id", nativeQuery = true)
    CustomerEntity getById (@Param("id") String id);
}
