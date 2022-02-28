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

import com.electronic.entity.Product;
import com.electronic.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	@RequestMapping("product/list/{id}")
	public String list(Model model, @PathVariable("id") Integer id) {
		List<Product> lstProduct = productService.findByCategoryId(id);
		for(Product p : lstProduct) {
			System.out.println(p.getName());
		}
		
		model.addAttribute("lstProduct", lstProduct);
		return "home/index";
	}
}
