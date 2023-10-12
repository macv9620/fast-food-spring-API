package com.macv.fastfood.persistence.repository;

import com.macv.fastfood.persistence.entity.PizzaEntity;
import com.macv.fastfood.service.dto.UpdatePizzaPriceDTO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {
    public List<PizzaEntity> findByNameContainingIgnoreCase(String subName);

    public List<PizzaEntity> findAllByOrderByPriceAsc();

    public List<PizzaEntity> findTop3ByOrderByPriceAsc();

    @Query(value =
                    "UPDATE pizza " +
                    "SET price = :#{#updatePizzaPriceDTO.newPrice} " +
                    "WHERE id_pizza = :#{#updatePizzaPriceDTO.pizzaId}", nativeQuery = true)
    @Modifying
    void updatePrice(@Param("updatePizzaPriceDTO") UpdatePizzaPriceDTO updatePizzaPriceDTO);
}
