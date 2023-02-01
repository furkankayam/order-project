package com.furkankaya.controller;

import com.furkankaya.dto.request.CustomerCreateUpdateDto;
import com.furkankaya.dto.response.CustomerDto;
import com.furkankaya.service.impl.CustomerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }


    //LIST
    // http://localhost:8080/api/v1/customers
    @GetMapping
    public ResponseEntity<List<CustomerDto>> getCustomer() {
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }

    //FIND
    // http://localhost:8080/api/v1/customers/1
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findCustomerById(@PathVariable long id) {
        return new ResponseEntity<>(customerService.findCustomerById(id), HttpStatus.OK);
    }

    //CREATE
    // http://localhost:8080/api/v1/customers
    @PostMapping
    public ResponseEntity<CustomerCreateUpdateDto> createCustomer(
            @RequestBody CustomerCreateUpdateDto customerCreateUpdateDto) {
        return new ResponseEntity<>(customerService.createCustomer(customerCreateUpdateDto), HttpStatus.CREATED);
    }

    //UPDATE
    // http://localhost:8080/api/v1/customers/1
    @PutMapping("/{id}")
    public ResponseEntity<CustomerCreateUpdateDto> updateCustomer(@PathVariable long id,
                                                                  @RequestBody CustomerCreateUpdateDto customerCreateUpdateDto) {
        return new ResponseEntity<>(customerService.updateCustomer(id, customerCreateUpdateDto), HttpStatus.OK);
    }

    //DELETE
    // http://localhost:8080/api/v1/customers/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable long id) {
        return  new ResponseEntity<>(customerService.deleteCustomer(id), HttpStatus.OK);
    }

    //LIST NO ORDERS
    // http://localhost:8080/api/v1/customers/noorders
    @GetMapping("/noorders")
    public ResponseEntity<List<CustomerDto>> getCustomerNoOrders() {
        return new ResponseEntity<>(customerService.NoOrdersCustomer(), HttpStatus.OK);
    }

    //SEARCH CUSTOMER
    // http://localhost:8080/api/v1/cutomers/name/fur
    @GetMapping("/name/{name}")
    public ResponseEntity<List<CustomerDto>> searchCustomer(@PathVariable String name) {
        return new ResponseEntity<>(customerService.SearchName(name), HttpStatus.OK);
    }

}
