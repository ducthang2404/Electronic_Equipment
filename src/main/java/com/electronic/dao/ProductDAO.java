package com.electronic.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.electronic.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {
	@Query(value = "SELECT * FROM Products p WHERE categoryId =?1 ",nativeQuery = true)
	Page<Product> findByCategoryId(Integer id,Pageable pageable);
	
	@Query(value = "SELECT * FROM Products WHERE name like %?1%", nativeQuery = true)
	Page<Product> findByName(String name,Pageable pageable);
	
	@Query(value = "SELECT * FROM Products", nativeQuery = true)
	Page<Product> findAllByProduct(Pageable pageable);
	
}
