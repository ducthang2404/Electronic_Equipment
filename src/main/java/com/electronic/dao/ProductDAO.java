package com.electronic.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.electronic.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {
	@Query(value = "SELECT * FROM Products p WHERE providerId =?1 ",nativeQuery = true)
	List<Product> findByCategoryId(Integer id);
}
