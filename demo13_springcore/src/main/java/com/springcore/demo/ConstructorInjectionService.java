package com.springcore.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ConstructorInjectionService {

	private Payment payment;

	public ConstructorInjectionService(@Qualifier("creditCardPayment") Payment payment) {
		this.payment = payment;
	}

	public void makePayment() {
		payment.pay(1000);
	}

}
