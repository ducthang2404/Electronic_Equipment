package com.electronic.controller;

import java.util.List;

import org.hibernate.service.internal.ProvidedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.electronic.entity.Category;
import com.electronic.entity.Product;
import com.electronic.entity.Provider;
import com.electronic.service.CategoryService;
import com.electronic.service.ProductService;
import com.electronic.service.ProviderService;
import com.electronic.until.FilesStorageService;

import lombok.experimental.PackagePrivate;

@Controller
public class ProductAdminController {

	@Autowired
	private ProductService productService;
	@Autowired
	private ProviderService providerService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private FilesStorageService storageService;

	@RequestMapping("admin/product")
	public String listProduct(Model model) {
		List<Product> listProducts = productService.listProduct();
		model.addAttribute("listProducts", listProducts);
		return "Product";
	}

	@RequestMapping("admin/createProduct")
	public String createProduct(Model model) {
		List<Provider> listProviders = providerService.listAll();
		model.addAttribute("listProviders", listProviders);

		List<Category> listCategories = categoryService.findAll();
		model.addAttribute("listCategories", listCategories);

		Product product = new Product();
		model.addAttribute("product", product);

		return "CreateProduct";
	}

	@RequestMapping(value = "admin/addProduct", method = RequestMethod.POST)
	public String addProduct(Model model, @ModelAttribute("product") Product product,
			@RequestParam("file") MultipartFile file) {
		storageService.saveone(file);
		product.setImages(file.getOriginalFilename());
		productService.addProduct(product);
		return "redirect:/admin/product";
	}

}
