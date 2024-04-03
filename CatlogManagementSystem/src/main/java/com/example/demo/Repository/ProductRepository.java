package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("SELECT p FROM Product p WHERE (:name IS NULL OR p.name LIKE %:name%) ")
	List<Product> findProductByName(String name);

	@Query("SELECT p FROM Product p WHERE (:brand IS NULL OR p.brand LIKE %:brand%)")
	List<Product> findByBrand(String brand);

	@Query("SELECT p FROM Product p WHERE (:description IS NULL OR p.description = :description)")
	List<Product> findByDescription(String description);

	@Query("SELECT p FROM Product p WHERE (:price IS NULL OR p.price = :price)")
	List<Product> findByPrice(double price);

	@Query("SELECT p FROM Product p WHERE (:quantity IS NULL OR p.quantity = :quantity)")
	List<Product> findByQuantity(int quantity);

	@Query("SELECT p FROM Product p WHERE (:category IS NULL OR p.category = :category)")
	List<Product> findByCategory(String category);
	
	@Query("SELECT p FROM Product p " +

"WHERE (:name IS NULL OR p.name LIKE %:name%) " +
"AND (:description IS NULL OR p.description = %:description%) " +
"AND (:brand IS NULL OR p.brand = %:brand%) " +
"AND (:price IS NULL OR p.price = :price) " +
"AND (:price IS NULL OR p.quantity = :quantity) " +
"AND (category IS NULL OR p.category = %:category%)")
	List<Product> findProductBySearch(@Param("name")String name, @Param("brand")String brand,@Param("description") String description, @Param("price")double price,@Param("quantity") int quantity);

	
}
