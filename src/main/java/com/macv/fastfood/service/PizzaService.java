package com.macv.fastfood.service;

import com.macv.fastfood.persistence.entity.PizzaEntity;
import com.macv.fastfood.persistence.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository){
        this.pizzaRepository = pizzaRepository;
    }

    public List<PizzaEntity> getAll(){
        return pizzaRepository.findAll();
    }

    //Obtener Pizza por id
    public PizzaEntity getById(Integer id){
        return pizzaRepository.findById(id).orElse(null);
    }

    //Guardar pizza
    public PizzaEntity add(PizzaEntity pizzaEntity) throws Exception {
        return pizzaRepository.save(pizzaEntity);
    }
}
