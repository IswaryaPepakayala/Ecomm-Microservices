package com.example.orderservice.entity;

public class OrderProducts {
	private String productTitle;
	private String categoryName;
	private double ProductCost;

	public OrderProducts() {
	}
	
	public OrderProducts(String productTitle, double productCost) {
		super();
		this.productTitle = productTitle;
		ProductCost = productCost;
	}

	public OrderProducts(String productTitle, String categoryName, double productCost) {
		super();
		this.productTitle = productTitle;
		this.categoryName = categoryName;
		ProductCost = productCost;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public double getProductCost() {
		return ProductCost;
	}

	public void setProductCost(double productCost) {
		ProductCost = productCost;
	}

}
