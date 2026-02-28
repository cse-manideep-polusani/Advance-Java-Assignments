package com.spring.demo.dao;

import org.springframework.stereotype.Repository;

import com.spring.demo.model.*;

import java.util.*;

@Repository
public class ProductDAO {
	public List<Product> getAllProducts(){
		List<Product> allProducts = new ArrayList<>();
		Product p1 = new Product(1,"Manideep",1000.00);
		Product p2 = new Product(2,"Ram",1900.00);
		Product p3 = new Product(3,"Rahul",8000.00);
		
		allProducts.add(p1);
		allProducts.add(p2);
		allProducts.add(p3);
		
		return allProducts;
	}
}
