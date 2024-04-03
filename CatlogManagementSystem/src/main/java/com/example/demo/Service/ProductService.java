package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Product;

import jakarta.validation.Valid;

@Service
public interface ProductService {

	List<Product> getAllProducts();

	Product getProductById(Long id);

	Product createProduct(@Valid Product product);

	Product updateProduct(Long id, @Valid Product product);

	void deleteProduct(Long id);

	 List<Product> getProductByName(String name);

	List<Product> getProductByBrand(String brand);

	List<Product> getProductByDescription(String description);

	List<Product> getProductByPrice(double price);

	List<Product> getProductByQuantity(int quantity);

	List<Product> getProductByCategory(String category);

	List<Product> getProductBySearch(String name, String brand, String description, double price, int quantity,
			String category);



	
}
