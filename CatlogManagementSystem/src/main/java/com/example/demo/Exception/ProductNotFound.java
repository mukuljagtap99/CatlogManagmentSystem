package com.example.demo.Exception;


public class ProductNotFound extends RuntimeException{

	public ProductNotFound() {
		
	}
	
	
	
    public ProductNotFound(String message)
    {
    	super(message);
    }
	
}
