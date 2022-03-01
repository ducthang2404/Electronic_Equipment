package com.electronic.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.electronic.entity.Product;

public interface ProductService {

	List<Product> findByCategoryId(Integer id);
	
	List<Product> findByName(String name);
	
	Page<Product> findAllByProduct(int page, int size);

}
