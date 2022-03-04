package com.electronic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
	private static final int SIZE = 6;
	
	//search theo idcategory
	@RequestMapping("product/list/{id}")
	public String listProduct(Model model, @PathVariable("id") Integer id,
			@RequestParam(name = "page", defaultValue = "1") int page) {
		
		Page<Product> lstProduct = productService.findByCategoryId(id, page-1, SIZE);
		model.addAttribute("lstProduct", lstProduct.getContent());
		model.addAttribute("totalPage", lstProduct.getTotalPages());
		model.addAttribute("currentPageLike", page);
		
		List<Category> list = categoryService.findAll();
		model.addAttribute("lstCategory", list);
		return "product/list";
	}

	
	//search 
	@RequestMapping("/search")
	public String search(Model model, @RequestParam("name") String name,
			@RequestParam(name="page",defaultValue = "1") int page) {
		
		Page<Product> lstProduct = productService.findByName(name, page-1, SIZE);
		model.addAttribute("lstProduct", lstProduct.getContent());
		model.addAttribute("totalPage", lstProduct.getTotalPages());
		model.addAttribute("currentPageLike", page);
		
		List<Category> list = categoryService.findAll();
		model.addAttribute("lstCategory", list);
		return "product/list";
	}
	
	//search theo id product
	@RequestMapping("/product/detail/{id}")
	public String productdetails(Model model, @PathVariable("id") Integer id,
			@RequestParam(name = "page", defaultValue = "1") int page) {
		Product product = productService.getById(id);
		model.addAttribute("product", product);
		
		Page<Product> lstProduct =productService.findByCategoryId(product.getCategory().getId(),page-1, 8);
		model.addAttribute("lstProduct",lstProduct);
		model.addAttribute("totalPage", lstProduct.getTotalPages());
		model.addAttribute("currentPageLike", page);
		return "product/detail";
	}

}
