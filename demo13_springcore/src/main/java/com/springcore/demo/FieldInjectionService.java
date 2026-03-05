package com.springcore.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FieldInjectionService {

    @Autowired
    @Qualifier("creditCardPayment")
    private Payment payment;

    public void makePayment() {
        payment.pay(3000);
    }

}
