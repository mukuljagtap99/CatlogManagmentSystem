package com.example.demo.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Product;
import com.example.demo.Exception.ProductNotFound;
import com.example.demo.Repository.ProductRepository;

import jakarta.validation.Valid;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() throws ProductNotFound {
		// TODO Auto-generated method stub
		
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Long id) throws ProductNotFound {
		// TODO Auto-generated method stub
		
		Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not Found with this Id :" + id));
		
		return product;
	}

	@Override
	public Product createProduct(@Valid Product product) {
		// TODO Auto-generated method stub
		
		product.setDateAdded(new Date());
		
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Long id, @Valid Product product) throws ProductNotFound {
		// TODO Auto-generated method stub
		Product productForUpdate = getProductById(id);
		
		productForUpdate.setBrand(product.getBrand());
		productForUpdate.setCategory(product.getCategory());
		productForUpdate.setDescription(product.getDescription());
		productForUpdate.setName(product.getName());
		productForUpdate.setPrice(product.getPrice());
		productForUpdate.setQuantity(product.getQuantity());
		
		
		return productRepository.save(productForUpdate);
	}

	@Override
	public void deleteProduct(Long id) throws ProductNotFound {
		// TODO Auto-generated method stub
		
		
		Product product = getProductById(id);
		
		productRepository.delete(product);
	}

	@Override
	public List<Product> getProductByName(String name) throws ProductNotFound{
		// TODO Auto-generated method stub
		
	  return productRepository.findProductByName(name);
		
	
	}

	@Override
	public List<Product> getProductByBrand(String brand) throws ProductNotFound {
		// TODO Auto-generated method stub
	
		return productRepository.findByBrand(brand);
	}

	@Override
	public List<Product> getProductByDescription(String description) throws ProductNotFound {
		// TODO Auto-generated method stub
		return productRepository.findByDescription(description);
	}

	@Override
	public List<Product> getProductByPrice(double price) throws ProductNotFound {
		// TODO Auto-generated method stub
		return productRepository.findByPrice(price);
	}

	@Override
	public List<Product> getProductByQuantity(int quantity) throws ProductNotFound {
		// TODO Auto-generated method stub
		return  productRepository.findByQuantity(quantity);
	}

	@Override
	public List<Product> getProductByCategory(String category) throws ProductNotFound {
		// TODO Auto-generated method stub
		return  productRepository.findByCategory(category);
	}

	@Override
	public List<Product> getProductBySearch(String name, String brand, String description, double price, int quantity,
			String category) throws ProductNotFound {
		// TODO Auto-generated method stub
		
		   if ((name != null && !name.trim().isEmpty()) || (brand != null && brand.trim().isEmpty()) || (description != null && description.trim().isEmpty()) || (price >= 0 ) || (quantity >= 0 )) {
	          
			   return productRepository.findProductBySearch(name,brand,description,price,quantity);
	        }
		   else
		   {
			   throw new ProductNotFound("Product are not found of search");  
	        }
		 
		
	}
	
	
	
	
	
	
	
	
	
}
