package com.example.demo.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Product;
import com.example.demo.Service.ProductService;

import jakarta.validation.Valid;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	private static final Logger logTrack = LoggerFactory.getLogger(ProductController.class);
	
	
	@GetMapping("/products")
	public List<Product> getAllProducts()
	{
		logTrack.trace("Get All Products");
		return productService.getAllProducts();
	}
	
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") Long id)
	{
		
		logTrack.trace("Get Products By Id");
		
		Product product = productService.getProductById(id);
		
		return ResponseEntity.ok().body(product);
	}
	
	
	
	@PostMapping("/products/create")
	public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product)
	{
		logTrack.trace("Product is Create");
		
		Product createProduct = productService.createProduct(product);
		
		return new ResponseEntity<>(createProduct, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/products/update/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @Valid @RequestBody Product product)
	{
		logTrack.trace("Product is update");
		
		Product updateProduct = productService.updateProduct(id,product);
		
		return ResponseEntity.ok().body(updateProduct);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id)
	{
		logTrack.trace("Product is Delete");
		
		productService.deleteProduct(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
	@GetMapping("/product/{name}")
	public List<Product> getProductByName(@RequestParam String name){
		
		logTrack.trace("Get product by name");
		
		return productService.getProductByName(name);
	}
	
	
	@GetMapping("/product/{brand}")
	public List<Product> getProductByBrand(@RequestParam String brand){
		
		logTrack.trace("Get product by brand");
		
		return productService.getProductByBrand(brand);
	}
	
	
	@GetMapping("/product/{description}")
	public List<Product> getProductByDescription(@RequestParam String description){
		
		logTrack.trace("Get product by description");
		
		return productService.getProductByDescription(description);
	}
	
	
	@GetMapping("/product/{price}")
	public List<Product> getProductByPrice(@RequestParam double price){
		
		logTrack.trace("Get product by price");
		
		return productService.getProductByPrice(price);
	}
	
	@GetMapping("/product/{quantity}")
	public List<Product> getProductByQuantity(@RequestParam int quantity){
		
		logTrack.trace("Get product by quantity");
		
		return productService.getProductByQuantity(quantity);
	}
	
	
	@GetMapping("product/{category}")
	public List<Product> getProductByCategory(@RequestParam String category){
		
		logTrack.trace("Get product by category");
		
		return productService.getProductByCategory(category);
	}
	
	@GetMapping("/productSearch")
	public List<Product> getAllProductsBySearch(@RequestParam String name, @RequestParam String brand, @RequestParam String description, @RequestParam double price, @RequestParam int quantity, @RequestParam String category)
	{
		return productService.getProductBySearch(name,brand,description,price, quantity,category);
	}
	
}
