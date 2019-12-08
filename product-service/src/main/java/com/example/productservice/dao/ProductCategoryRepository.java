package com.example.productservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productservice.entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>{

}
