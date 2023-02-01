package com.furkankaya.service;

import com.furkankaya.dto.request.CustomerCreateUpdateDto;
import com.furkankaya.dto.response.CustomerDto;
import com.furkankaya.model.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {

    Customer isThereCustomer(long id);
    List<CustomerDto> getAllCustomer();
    CustomerCreateUpdateDto createCustomer(CustomerCreateUpdateDto customerCreateUpdateDto);
    CustomerCreateUpdateDto updateCustomer(long id, CustomerCreateUpdateDto customerCreateUpdateDto);
    CustomerDto findCustomerById(long id);
    Map<String, Boolean> deleteCustomer(long id);

    ///////////////////////////////////////////////////////////
    //Search Name
    List<CustomerDto> SearchName(String name);

    ///////////////////////////////////////////////////////////
    //Users without an order
    List<CustomerDto> NoOrdersCustomer();

    ///////////////////////////////////////////////////////////
    //Mapper
    CustomerDto EntityToDtoCustomer(Customer customer);
    Customer CreateDtoToEntity(CustomerCreateUpdateDto customerCreateUpdateDto);

}
