package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Component
@Primary
//@Scope("prototype")
public class Bike implements Vechile {
	public Bike() {
		System.out.println("Bike been created by spring");
	}
	
	@Override
	public void run() {
		System.out.println("Bike running...");
	}
}
