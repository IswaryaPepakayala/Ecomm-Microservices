package com.example.orderservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.orderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer>{

}
