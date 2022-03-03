package com.electronic.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.electronic.dao.ProductDAO;
import com.electronic.entity.Product;
import com.electronic.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDAO productDAO;

	@Override
	public Page<Product> findByCategoryId(Integer id, int page, int size) {
		return productDAO.findByCategoryId(id, PageRequest.of(page, size));
	}

	@Override
	public Page<Product> findByName(String name, int page, int size) {
		return productDAO.findByName(name,PageRequest.of(page, size));
	}

	@Override
	public Page<Product> findAllByProduct(int page, int size) {
		return productDAO.findAllByProduct(PageRequest.of(page, size));
	}
	public Product getById(Integer id){
		return productDAO.getById(id);
	}

}
