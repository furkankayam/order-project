package com.furkankaya.repository;

import com.furkankaya.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "select a from Order a where a.createDate > ?1")
    List<Order> searchDate(Date date);

}
