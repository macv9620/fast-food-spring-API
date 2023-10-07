package com.macv.fastfood.persistence.repository;

import com.macv.fastfood.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {
    public List<PizzaEntity> findByNameContainingIgnoreCase(String subName);

    public List<PizzaEntity> findAllByOrderByPriceAsc();

    public List<PizzaEntity> findTop3ByOrderByPriceAsc();
}
