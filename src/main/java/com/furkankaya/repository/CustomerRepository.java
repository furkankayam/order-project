package com.furkankaya.repository;

import com.furkankaya.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "select c from Customer c where c.name like %:name%")
    List<Customer> searchName(@Param("name") String name);

}
