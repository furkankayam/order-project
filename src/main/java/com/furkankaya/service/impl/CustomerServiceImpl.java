package com.furkankaya.service.impl;

import com.furkankaya.dto.request.CustomerCreateUpdateDto;
import com.furkankaya.dto.response.CustomerDto;
import com.furkankaya.exception.ResourceNotFoundException;
import com.furkankaya.model.Customer;
import com.furkankaya.repository.CustomerRepository;
import com.furkankaya.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer isThereCustomer(long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Customer ID: " + id)
                );
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDto> customerDtoList =
                customerList
                        .stream()
                        .map(this::EntityToDtoCustomer)
                        .collect(Collectors.toList());
        log.debug("Get All Customer");
        return customerDtoList;
    }

    @Override
    public CustomerCreateUpdateDto createCustomer(CustomerCreateUpdateDto customerCreateUpdateDto) {
        Customer customer = CreateDtoToEntity(customerCreateUpdateDto);
        customerRepository.save(customer);
        log.debug("Create Customer");
        return customerCreateUpdateDto;
    }

    @Override
    public CustomerCreateUpdateDto updateCustomer(long id, CustomerCreateUpdateDto customerCreateUpdateDto) {
        Customer customer = isThereCustomer(id);
        customer.setName(customerCreateUpdateDto.getName());
        customer.setAge(customerCreateUpdateDto.getAge());
        customerRepository.save(customer);
        log.debug("Update Customer");
        return customerCreateUpdateDto;
    }

    @Override
    public CustomerDto findCustomerById(long id) {
        CustomerDto customerDto = EntityToDtoCustomer(isThereCustomer(id));
        log.debug("Find Customer");
        return customerDto;
    }

    @Override
    public Map<String, Boolean> deleteCustomer(long id) {
        isThereCustomer(id);
        customerRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Delete", Boolean.TRUE);
        log.debug("Delete Customer");
        return response;
    }

    //////////////////////////////////////////////////////////////
    //Search Name
    @Override
    public List<CustomerDto> SearchName(String name) {
        List<Customer> customerList = customerRepository.searchName(name);
        List<CustomerDto> customerDtoList =
                customerList
                        .stream()
                        .map(this::EntityToDtoCustomer)
                        .collect(Collectors.toList());
        return customerDtoList;
    }

    //////////////////////////////////////////////////////////////
    //Users without an order
    @Override
    public List<CustomerDto> NoOrdersCustomer() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDto> customerDtoList =
                new ArrayList<>();
        for (Customer temp: customerList) {
            if (temp.getOrders().isEmpty()) {
                CustomerDto customer = EntityToDtoCustomer(temp);
                customerDtoList.add(customer);
            }
        }
        return customerDtoList;
    }


    ////////////////////////////////////////////////////////////////
    //Mapper
    @Override
    public CustomerDto EntityToDtoCustomer(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setAge(customer.getAge());
        customerDto.setOrders(customer.getOrders());
        return customerDto;
    }

    @Override
    public Customer CreateDtoToEntity(CustomerCreateUpdateDto customerCreateUpdateDto) {
        Customer customer = new Customer();
        customer.setName(customerCreateUpdateDto.getName());
        customer.setAge(customerCreateUpdateDto.getAge());
        return customer;
    }
}
