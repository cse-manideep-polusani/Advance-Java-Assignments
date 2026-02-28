package com.payment.demo;

import org.springframework.stereotype.Component;

@Component
public class Upi implements Payment{
	public Upi() {
		System.out.println("Upi obj created");
	}
	@Override
	public void pay() {
		System.out.println("Paying via Upi");
	}
}