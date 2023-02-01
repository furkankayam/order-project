package com.furkankaya.dto.response;

import java.util.Date;

public class OrderListDto {

    private long id;
    private Date createDate;
    private long totalPrice;
    private long customerId;

    public OrderListDto() {
    }

    public OrderListDto(long id,
                        Date createDate,
                        long totalPrice,
                        long customerId) {
        this.id = id;
        this.createDate = createDate;
        this.totalPrice = totalPrice;
        this.customerId = customerId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getCustomerId(long id) {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}
