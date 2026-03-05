package com.springcore.demo;

import org.springframework.stereotype.Component;

@Component
public class CreditCardPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid using Credit Card: " + amount);
    }

}
