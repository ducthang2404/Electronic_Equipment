package com.electronic.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.electronic.entity.Product;

public interface ProductService {

	Page<Product> findByCategoryId(Integer id,int page, int size);
	
	Page<Product> findByName(String name,int page, int size);
	
	Page<Product> findAllByProduct(int page, int size);
	
	Product getById(Integer id);
	
	List<Product> findByCategoryIds(Integer cid);

}
