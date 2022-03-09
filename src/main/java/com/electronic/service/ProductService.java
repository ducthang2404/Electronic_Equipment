package com.electronic.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.electronic.entity.Product;

public interface ProductService {

	Page<Product> findByCategoryId(Integer id,int page, int size);
	
	Page<Product> findByName(String name,int page, int size);
	
	Page<Product> findAllByProduct(int page, int size);
	
<<<<<<< HEAD
	Product findById(Integer id);
=======
	Product getById(Integer id);
	
	List<Product> findByCategoryIds(Integer cid);
	
	public List<Product> listProduct();
	
	public void addProduct(Product product);

>>>>>>> e23d1fcd62227c19f8664e48dbb7f4056c7d50e7
}
