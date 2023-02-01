package com.furkankaya.dto.request;

public class OrderUpdateDto {

    private long totalPrice;

    public OrderUpdateDto() {
    }

    public OrderUpdateDto(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }
}
