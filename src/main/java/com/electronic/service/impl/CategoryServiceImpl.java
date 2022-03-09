package com.electronic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronic.dao.CategoryDAO;
import com.electronic.entity.Category;

import com.electronic.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired 
	CategoryDAO categoryDAO;
	
	@Override
	public List<Category> findAll() {
		return categoryDAO.findAll();
	}
	


}
