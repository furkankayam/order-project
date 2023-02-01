package com.furkankaya.dto.response;

import com.furkankaya.model.Order;

import java.util.List;

public class CustomerDto {

    private long id;
    private String name;
    private int age;
    private List<Order> orders;

    public CustomerDto() {
    }

    public CustomerDto(long id,
                       String name,
                       int age,
                       List<Order> orders) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.orders = orders;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
