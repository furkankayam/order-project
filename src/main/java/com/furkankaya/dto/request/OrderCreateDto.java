package com.furkankaya.dto.request;

public class OrderCreateDto {
    private long totalPrice;
    private long customerId;

    public OrderCreateDto() {
    }

    public OrderCreateDto(long totalPrice,
                          long customerId) {
        this.totalPrice = totalPrice;
        this.customerId = customerId;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}
