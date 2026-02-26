package com.springcore.demo;

import org.springframework.stereotype.Component;

@Component
public class DieselEngine implements Engine{
	
	public DieselEngine() {
		System.out.println("Diesel Engine bean created");
	}
	
	@Override
	public String getEngine() {
		return "Diesel Engine";
	}
}
