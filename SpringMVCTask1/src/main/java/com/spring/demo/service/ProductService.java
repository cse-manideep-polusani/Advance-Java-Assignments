package com.spring.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.dao.*;
import com.spring.demo.model.*;

import java.util.*;

@Service
public class ProductService {
	
	private ProductDAO productDAO;
	
	@Autowired
	public ProductService(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	public List<Product> fetchProducts(){
		return productDAO.getAllProducts();
	}
}
