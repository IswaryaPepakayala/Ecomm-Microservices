package com.example.orderservice.entity;

import java.util.List;

public class OrderProduct {
	private int orderId;
	private List<OrderProducts> productDetails;
	private double totalCost;

	public OrderProduct() {

	}

	public OrderProduct(int orderId, List<OrderProducts> productDetails, double totalCost) {
		super();
		this.orderId = orderId;
		this.productDetails = productDetails;
		this.totalCost = totalCost;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public List<OrderProducts> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(List<OrderProducts> productDetails) {
		this.productDetails = productDetails;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

}
