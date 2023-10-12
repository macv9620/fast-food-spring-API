package com.macv.fastfood.service;

import com.macv.fastfood.persistence.entity.PizzaEntity;
import com.macv.fastfood.persistence.repository.PizzaPagSortRepository;
import com.macv.fastfood.persistence.repository.PizzaRepository;
import com.macv.fastfood.service.dto.UpdatePizzaPriceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;
    private final PizzaPagSortRepository pizzaPagSortRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository, PizzaPagSortRepository pizzaPagSortRepository){
        this.pizzaRepository = pizzaRepository;
        this.pizzaPagSortRepository = pizzaPagSortRepository;
    }

    public List<PizzaEntity> getAll(){
        return pizzaRepository.findAll();
    }

    //Obtener Pizza por id
    public PizzaEntity getById(Integer id){
        return pizzaRepository.findById(id).orElse(null);
    }

    //Guardar pizza
    public PizzaEntity add(PizzaEntity pizza) throws Exception {
        return pizzaRepository.save(pizza);
    }

    //Validar si un registro ya existe
    public boolean exists(int pizzaId){
        return pizzaRepository.existsById(pizzaId);
    }

    //Eliminar un producto
    public void deleteById(int pizzaId){
        pizzaRepository.deleteById(pizzaId);
    }

    //Obtener listado de productos buscando una expresión en su nombre
    public List<PizzaEntity> searchByNameExpression(String expression){
        return pizzaRepository.findByNameContainingIgnoreCase(expression);
    }

    //Pizzas ordenadas por precio de menor a mayor
    public List<PizzaEntity> getOrderedPizzasAsc(){
        return pizzaRepository.findAllByOrderByPriceAsc();
    }

    //Obtener pizzas paginadas, recibiendo un número de página y una cantidad de elementos por página

    public Page<PizzaEntity> getPaginatedPizzas(int page, int elementsQuantity){
        Pageable pageable = PageRequest.of(page, elementsQuantity);
        return pizzaPagSortRepository.findAll(pageable);
    }

    @Transactional(noRollbackFor = EmailException.class)
    public void updatePrice(UpdatePizzaPriceDTO updatePizzaPriceDTO){
        pizzaRepository.updatePrice(updatePizzaPriceDTO);
        sendEmail();
    }

    private void sendEmail(){
        throw new EmailException();
    }
}
