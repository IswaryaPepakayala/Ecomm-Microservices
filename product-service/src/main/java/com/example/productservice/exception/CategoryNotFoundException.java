package com.example.productservice.exception;

public class CategoryNotFoundException extends RuntimeException{
	public CategoryNotFoundException() {
        super();
    }
	public CategoryNotFoundException(String message) {
        super(message);
    }

}
