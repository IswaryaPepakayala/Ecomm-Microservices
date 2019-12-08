package com.example.orderservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.dao.OrderDetailRepository;
import com.example.orderservice.dao.OrderRepository;
import com.example.orderservice.entity.Order;
import com.example.orderservice.entity.OrderDetails;

@RestController
public class OrderDetailController {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	@PostMapping("/orders/{orderId}/details")
	public void createOrderDetails(@PathVariable int orderId,@RequestBody OrderDetails details) {
		Optional<Order> orders = orderRepository.findById(orderId);
		details.setOrder(orders.get());
		orderDetailRepository.save(details);
	}
	
}
