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
	public List<Product> findByCategoryId(Integer id) {
		return productDAO.findByCategoryId(id);
	}

	@Override
	public List<Product> findByName(String name) {
		return productDAO.findByName(name);
	}

	@Override
	public Page<Product> findAllByProduct(int page, int size) {
		return productDAO.findAllByProduct(PageRequest.of(page, size));
	}

}
