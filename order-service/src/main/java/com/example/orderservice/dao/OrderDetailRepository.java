package com.example.orderservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.orderservice.entity.OrderDetails;

public interface OrderDetailRepository extends JpaRepository<OrderDetails,Integer>{

}
