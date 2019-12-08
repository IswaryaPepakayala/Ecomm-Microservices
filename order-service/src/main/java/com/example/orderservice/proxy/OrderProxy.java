package com.example.orderservice.proxy;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.orderservice.entity.Product;

@FeignClient(name="product-service")
public interface OrderProxy {
	
	@GetMapping("/categories/{categoryId}/products")
	public List<Product> products(@PathVariable(value = "categoryId") int id);
	@GetMapping("/products/{id}")
	public Optional<Product> getProduct(@PathVariable int id);
}
