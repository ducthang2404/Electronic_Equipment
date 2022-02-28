package com.electronic.service;

import java.util.List;

import com.electronic.entity.Product;

public interface ProductService {

	List<Product> findByCategoryId(Integer id);
}
