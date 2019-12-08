package com.example.orderservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.dao.OrderRepository;
import com.example.orderservice.entity.Order;
import com.example.orderservice.entity.OrderDetails;
import com.example.orderservice.entity.OrderProduct;
import com.example.orderservice.entity.OrderProducts;
import com.example.orderservice.entity.Product;
import com.example.orderservice.entity.ProductCategory;
import com.example.orderservice.proxy.OrderProxy;

@RestController
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderProxy orderProxy;
	@PostMapping("/orders")
	public void createOrder(@RequestBody Order order) {
		orderRepository.save(order);
	}
	@GetMapping("/orders/{orderId}")
	public OrderProduct retrieveProducts(@PathVariable int orderId) {
		Optional<Order> order=orderRepository.findById(orderId);
		Set<OrderDetails> details= order.get().getOrderDetails();
		OrderProducts productDetails=null;
		List<OrderProducts> orderProductDetails=new ArrayList<OrderProducts>();
		for(OrderDetails orderDetail:details) {
			int id=orderDetail.getProductId();
			Optional<Product> products=orderProxy.getProduct(id);
			Product product=products.get();
			productDetails=new OrderProducts(product.getTitle(),product.getPrice());
			orderProductDetails.add(productDetails);
		}
		return new OrderProduct(orderId,orderProductDetails,order.get().getTotalCost());
		
	}
}
