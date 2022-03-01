package com.electronic.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.electronic.entity.Category;
import com.electronic.entity.Product;
import com.electronic.service.CategoryService;
import com.electronic.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("product/list/{id}")
	public String listProduct(Model model, @PathVariable("id") Integer id) {
		List<Product> lstProduct = productService.findByCategoryId(id);
		model.addAttribute("lstProduct", lstProduct);
		
		List<Category> list = categoryService.findAll();
		model.addAttribute("lstCategory", list);
		return "home/index";
	}
	
	@RequestMapping("/search")
	public String search(Model model, @RequestParam("name") String name) {
		
		List<Product> lstProduct = productService.findByName(name);
		model.addAttribute("lstProduct", lstProduct);
		
		List<Category> list = categoryService.findAll();
		model.addAttribute("lstCategory", list);
		return "home/index";
	}
}
