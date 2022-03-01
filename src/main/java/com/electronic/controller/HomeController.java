package com.electronic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.electronic.entity.Category;
import com.electronic.entity.Product;
import com.electronic.service.CategoryService;
import com.electronic.service.ProductService;


@Controller
public class HomeController {
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Product> lstProduct = productService.findAll();
		model.addAttribute("lstProduct", lstProduct);
		
		List<Category> list = categoryService.findAll();
		model.addAttribute("lstCategory", list);
		
		return "home/index";
	}
}
