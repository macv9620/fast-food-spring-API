package com.macv.fastfood.web.controller;

import com.macv.fastfood.persistence.entity.OrderEntity;
import com.macv.fastfood.persistence.projection.OrderSummary;
import com.macv.fastfood.persistence.repository.OrderRepository;
import com.macv.fastfood.service.OrderService;
import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<ResponseWrapper<?>> getAll(){
        String message;
        HttpStatus httpStatus;
        List<OrderEntity> data;
        try{
            data = orderService.getAll();
            message = data.size() + " orders Found";
            httpStatus = HttpStatus.OK;
            ResponseWrapper<List<OrderEntity>> responseWrapper = new ResponseWrapper<>(
               message,
               data
            );
            return new ResponseEntity<>(responseWrapper, httpStatus);
        } catch (Exception e){
            message = e.getMessage();
            data = null;
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            ResponseWrapper<?> responseWrapper = new ResponseWrapper<>(
                    message,
                    data
            );
            return new ResponseEntity<>(responseWrapper, httpStatus);
        }


    }

    @GetMapping("/getTodayOrders")
    public ResponseEntity<List<OrderEntity>> getTodayOrders(){
        return new ResponseEntity<>(orderService.getTodayOrders(), HttpStatus.OK);
    }

    @PostMapping("/newOrder")
    public ResponseEntity<ResponseWrapper<?>> postOrder(@RequestBody OrderEntity order){
        String message;
        OrderEntity data;
        HttpStatus httpStatus;

        try {
            message = "Order created successfully";
            data = orderService.save(order);
            httpStatus = HttpStatus.CREATED;
        } catch (Exception e){
            message = e.getMessage();
            data = null;
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        ResponseWrapper<OrderEntity> responseWrapper = new ResponseWrapper<>(
                message,
                data
        );
        return new ResponseEntity<>(responseWrapper, httpStatus);
    }

    @GetMapping("/getOrderSummaryById/{orderId}")
    public ResponseEntity<OrderSummary> getOrderSummary(@PathVariable int orderId){
        return new ResponseEntity<>(orderService.getOrderSummary(orderId), HttpStatus.OK);
    }

}
