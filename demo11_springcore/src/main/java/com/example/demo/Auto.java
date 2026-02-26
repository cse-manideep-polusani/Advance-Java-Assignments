package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;

@Component
@Scope("prototype")
public class Auto implements Vechile {
	public Auto() {
		System.out.println("Auto been created by spring");
	}
	
	@Override
	public void run() {
		System.out.println("Auto running...");
	}
}
