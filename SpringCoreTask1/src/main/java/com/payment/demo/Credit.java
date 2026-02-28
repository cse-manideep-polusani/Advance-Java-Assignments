package com.payment.demo;

import org.springframework.stereotype.Component;

@Component
public class Credit implements Payment{
	public Credit() {
		System.out.println("Credit card obj created");
	}
	@Override
	public void pay() {
		System.out.println("Paying via Credit Card");
	}
	
}