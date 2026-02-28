package com.payment.demo;

import org.springframework.stereotype.Component;

@Component
public class Crypto implements Payment{
	public Crypto() {
		System.out.println("Crypto obj created");
	}
	@Override
	public void pay() {
		System.out.println("Paying via Crypto currency!");
	}
	
}