package com.furkankaya.service.impl;

import com.furkankaya.dto.request.OrderCreateDto;
import com.furkankaya.dto.request.OrderUpdateDto;
import com.furkankaya.dto.response.OrderListDto;
import com.furkankaya.exception.ResourceNotFoundException;
import com.furkankaya.model.Order;
import com.furkankaya.repository.OrderRepository;
import com.furkankaya.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    private final OrderRepository orderRepository;
    private final CustomerServiceImpl customerService;

    public OrderServiceImpl(OrderRepository orderRepository,
                            CustomerServiceImpl customerService) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
    }


    @Override
    public Order isThereOrder(long id) {
        return orderRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Order ID: " + id)
                );
    }

    @Override
    public List<OrderListDto> getAllOrder() {
        List<Order> orderList = orderRepository.findAll();
        List<OrderListDto> orderDtoList =
                orderList
                        .stream()
                        .map(this::EntityToDtoOrder)
                        .collect(Collectors.toList());
        log.debug("Get All Order");
        return orderDtoList;
    }

    @Override
    public OrderListDto findOrderById(long id) {
        OrderListDto orderListDto = EntityToDtoOrder(isThereOrder(id));
        log.debug("Find Order");
        return orderListDto;
    }

    @Override
    public OrderListDto createOrder(OrderCreateDto orderCreateDto) {
        customerService.isThereCustomer(orderCreateDto.getCustomerId());
        Order order = DtoToEntityOrder(orderCreateDto);
        orderRepository.save(order);
        OrderListDto listDto = EntityToDtoOrder(order);
        log.debug("Create Order");
        return listDto;
    }

    @Override
    public OrderListDto updateOrder(long id, OrderUpdateDto orderUpdateDto) {
        Order order = isThereOrder(id);
        order.setTotalPrice(orderUpdateDto.getTotalPrice());
        orderRepository.save(order);
        OrderListDto orderListDto = EntityToDtoOrder(order);
        log.debug("Update Order");
        return orderListDto;
    }

    @Override
    public Map<String, Boolean> deleteOrder(long id) {
        isThereOrder(id);
        orderRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Delete", Boolean.TRUE);
        log.debug("Delete Order");
        return response;
    }

    ////////////////////////////////////////////////////////////////
    //Search Date
    @Override
    public List<OrderListDto> SearchDate(Date date) {
        List<Order> orderList = orderRepository.searchDate(date);
        List<OrderListDto> orderListDto =
                orderList
                        .stream()
                        .map(this::EntityToDtoOrder)
                        .collect(Collectors.toList());
        return orderListDto;
    }


    ////////////////////////////////////////////////////////////////
    //Mapper
    @Override
    public OrderListDto EntityToDtoOrder(Order order) {
        OrderListDto orderListDto = new OrderListDto();
        orderListDto.setId(order.getId());
        orderListDto.setCreateDate(order.getCreateDate());
        orderListDto.setTotalPrice(order.getTotalPrice());
        return orderListDto;
    }

    @Override
    public Order DtoToEntityOrder(OrderCreateDto orderCreateDto) {
        Order order = new Order();
        order.setTotalPrice(orderCreateDto.getTotalPrice());
        order.setCustomer(customerService.isThereCustomer(orderCreateDto.getCustomerId()));
        return order;
    }
}
