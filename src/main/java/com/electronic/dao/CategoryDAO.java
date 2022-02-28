package com.electronic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electronic.entity.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer>{

}
