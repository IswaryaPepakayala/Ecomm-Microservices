package com.example.productservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.productservice.dao.ProductCategoryRepository;
import com.example.productservice.entity.ProductCategory;
import com.example.productservice.exception.CategoryNotFoundException;

@RestController
public class ProductCategoryServiceController {

	@Autowired
	private ProductCategoryRepository categoryRepository;

	@GetMapping("/categories")
	public List<ProductCategory> allCategories() {
		List<ProductCategory> categories = this.categoryRepository.findAll();

		if (categories.isEmpty())
			throw new CategoryNotFoundException("No product category is available for sale !");

		return categories;
	}

	@GetMapping("/categories/{id}")
	public Optional<ProductCategory> getCategory(@PathVariable int id) {
		Optional<ProductCategory> category = this.categoryRepository.findById(id);

		if (!category.isPresent())
			throw new CategoryNotFoundException("Th product category " + id + " doesn't exist");

		return category;
	}

	@PostMapping("/categories")
	public void addCategory(@RequestBody ProductCategory category) {
		//category.setId(0);
		this.categoryRepository.save(category);
	}

	@PutMapping("/categories")
	public ProductCategory updateCategory(@RequestBody ProductCategory category) {
		this.categoryRepository.save(category);
		return category;
	}

	@DeleteMapping("/categories/{id}")
	public void deleteCategory(@PathVariable int id) {
		Optional<ProductCategory> category = this.categoryRepository.findById(id);

		if (!category.isPresent())
			throw new CategoryNotFoundException("The product category" + id + " doesn't exist");
		this.categoryRepository.deleteById(id);
	}

}
