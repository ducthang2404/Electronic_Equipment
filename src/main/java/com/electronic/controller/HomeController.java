package com.electronic.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	private static final int SIZE = 6;
	
	@GetMapping("/")
	public String index(Model model, HttpServletRequest request,
			 @RequestParam(name="page",defaultValue = "1") int page) {
		Page<Product> lstProduct = productService.findAllByProduct(page-1, SIZE);
		model.addAttribute("lstProduct", lstProduct.getContent());
		model.addAttribute("totalPage", lstProduct.getTotalPages());
		model.addAttribute("currentPageLike", page);
		
		List<Category> list = categoryService.findAll();
		model.addAttribute("lstCategory", list);
		
		return "home/index";
	}
}
