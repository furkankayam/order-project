package com.furkankaya.service;


import com.furkankaya.dto.request.OrderCreateDto;
import com.furkankaya.dto.request.OrderUpdateDto;
import com.furkankaya.dto.response.OrderListDto;
import com.furkankaya.model.Order;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OrderService {

    Order isThereOrder(long id);
    List<OrderListDto> getAllOrder();
    OrderListDto findOrderById(long id);
    OrderListDto createOrder(OrderCreateDto orderCreateDto);
    OrderListDto updateOrder(long id, OrderUpdateDto orderUpdateDto);
    Map<String, Boolean> deleteOrder(long id);

    /////////////////////////////////////////////////////
    //Search Order
    List<OrderListDto> SearchDate(Date date);


    /////////////////////////////////////////////////////
    //Mapper
    OrderListDto EntityToDtoOrder(Order order);
    Order DtoToEntityOrder(OrderCreateDto orderCreateDto);

}
