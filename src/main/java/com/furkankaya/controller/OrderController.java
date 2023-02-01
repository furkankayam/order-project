package com.furkankaya.controller;

import com.furkankaya.dto.request.OrderCreateDto;
import com.furkankaya.dto.request.OrderUpdateDto;
import com.furkankaya.dto.response.OrderListDto;
import com.furkankaya.service.impl.OrderServiceImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderServiceImpl orderService;

    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }


    //LIST
    // http://localhost:8080/api/v1/orders
    @GetMapping
    public ResponseEntity<List<OrderListDto>> getOrder() {
        return new ResponseEntity<>(orderService.getAllOrder(), HttpStatus.OK);
    }

    //FIND
    // http://localhost:8080/api/v1/orders/1
    @GetMapping("/{id}")
    public ResponseEntity<OrderListDto> findOrderById(@PathVariable long id) {
        return new ResponseEntity<>(orderService.findOrderById(id), HttpStatus.OK);
    }

    //CREATE
    // http://localhost:8080/api/v1/orders
    @PostMapping
    public ResponseEntity<OrderListDto> createOrder(@RequestBody OrderCreateDto orderCreateDto) {
        return new ResponseEntity<>(orderService.createOrder(orderCreateDto), HttpStatus.CREATED);
    }

    //UPDATE
    // http://localhost:8080/api/v1/orders/1
    @PutMapping("/{id}")
    public ResponseEntity<OrderListDto> updateOrder(@PathVariable long id,
                                                    @RequestBody OrderUpdateDto orderUpdateDto) {
        return new ResponseEntity<>(orderService.updateOrder(id, orderUpdateDto), HttpStatus.OK);
    }


    //DELETE
    // http://localhost:8080/api/v1/orders/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteOrder(@PathVariable long id) {
        return  new ResponseEntity<>(orderService.deleteOrder(id), HttpStatus.OK);
    }

    //SEARCH ORDER
    // http://localhost:8080/api/v1/orders/date/2023-01-24
    @GetMapping("/date/{date}")
    public ResponseEntity<List<OrderListDto>> searchOrder(@DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable Date date) {
        return new ResponseEntity<>(orderService.SearchDate(date), HttpStatus.OK);
    }

}
