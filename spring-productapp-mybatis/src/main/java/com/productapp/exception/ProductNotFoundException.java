package com.productapp.exception;

public class ProductNotFoundException extends RuntimeException{
	 public ProductNotFoundException() {
	    }

	    public ProductNotFoundException(String message) {
	        super(message);
	    }
}
