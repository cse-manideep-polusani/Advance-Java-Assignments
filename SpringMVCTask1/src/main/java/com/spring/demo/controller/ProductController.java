package com.spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.demo.model.*;
import com.spring.demo.service.ProductService;

@Controller
public class ProductController {
	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService=productService;
	}
	
	@GetMapping("/products")
	public String showProducts(Model model) {
	    List<Product> productList = productService.fetchProducts();
		model.addAttribute("products", productList);
		return "products";
	}
}
