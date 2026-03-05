package com.springcore.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SetterInjectionService {

	private Payment payment;

	@Autowired
	@Qualifier("upiPayment")
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public void makePayment() {
		payment.pay(2000);
	}

}
