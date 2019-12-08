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
import com.example.productservice.dao.ProductRepository;
import com.example.productservice.entity.Product;
import com.example.productservice.entity.ProductCategory;
import com.example.productservice.exception.ProductNotFoundException;

@RestController
public class ProductServiceController {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductCategoryRepository categoryRepository;

	@GetMapping("/categories/{categoryId}/products")
	public List<Product> products(@PathVariable(value = "categoryId") int id) {
		List<Product> products = this.productRepository.findByCategoryId(id);

		if (products.isEmpty())
			throw new ProductNotFoundException("No product is available for sale !");

		return products;
	}

	@GetMapping("/products/{id}")
	public Optional<Product> getProduct(@PathVariable int id) {
		Optional<Product> product = this.productRepository.findById(id);
		product.get().getCategory();

		if (!product.isPresent())
			throw new ProductNotFoundException("The product " + id + " doesn't exist");

		return product;
	}

	@PostMapping("/categories/{categoryId}/products")
	public void addProduct(@PathVariable int categoryId, @RequestBody Product product) {
		Optional<ProductCategory> category = this.categoryRepository.findById(categoryId);
		product.setCategory(category.get());
		this.productRepository.save(product);
	}

	@PutMapping("/categories/{categoryId}/products")
	public void updateProduct(@PathVariable int categoryId, @RequestBody Product product) {
		Optional<ProductCategory> category = this.categoryRepository.findById(categoryId);
		product.setCategory(category.get());
		this.productRepository.save(product);
	}

	@DeleteMapping("/categories/{categoryId}/products/{id}")
	public void deleteProduct(@PathVariable(value = "categoryId") int categoryId, @PathVariable(value = "id") int id) {
		Optional<Product> product = this.productRepository.findByIdAndCategoryId(id, categoryId);

		if (!product.isPresent())
			throw new ProductNotFoundException("Th product " + id + " doesn't exist");
		this.productRepository.deleteById(id);
	}

}
