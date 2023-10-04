package com.macv.fastfood.web.controller;

import com.macv.fastfood.persistence.entity.PizzaEntity;
import com.macv.fastfood.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pizza")
public class PizzaController {

    private final PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<ResponseWrapper<?>> getAll(){
        List<PizzaEntity> data = pizzaService.getAll();
        ResponseWrapper<List<PizzaEntity>> responseWrapper = new ResponseWrapper<>(
                data.size() + " products found",
                data
        );
      return ResponseEntity.ok(responseWrapper);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseWrapper<?>> getById(@PathVariable("id") Integer id){

        String message;
        HttpStatus httpStatus;

        PizzaEntity data = pizzaService.getById(id);

        if (data == null){
            message = "Product not found";
            httpStatus = HttpStatus.NOT_FOUND;
        } else {
            message = "Product found";
            httpStatus = HttpStatus.OK;
        }

        ResponseWrapper<PizzaEntity> responseWrapper = new ResponseWrapper<>(
                message,
                data
        );

        return new ResponseEntity<>(responseWrapper, httpStatus);
        }

}
