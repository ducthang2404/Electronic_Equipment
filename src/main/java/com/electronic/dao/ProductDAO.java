package com.electronic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electronic.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {
	
}
