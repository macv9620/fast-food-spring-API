package com.macv.fastfood.persistence.repository;

import com.macv.fastfood.persistence.entity.PizzaEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PizzaPagSortRepository extends PagingAndSortingRepository<PizzaEntity, Integer> {

}
