package com.example.productservice.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productservice.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{
	
	List<Product> findByCategoryId(int categoryId);
	 Optional<Product> findByIdAndCategoryId(int id, int categoryId);

}
