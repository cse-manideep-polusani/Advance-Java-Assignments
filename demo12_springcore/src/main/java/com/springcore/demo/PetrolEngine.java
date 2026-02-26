package com.springcore.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PetrolEngine implements Engine{
	
	public PetrolEngine() {
		System.out.println("Petrol Engine bean created");
	}
	
	@Override
	public String getEngine() {
		return "Petrol Engine";
	}
}
