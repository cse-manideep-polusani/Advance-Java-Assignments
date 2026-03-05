package com.springcore.demo;

import org.springframework.stereotype.Component;

@Component
public class UpiPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid using UPI: " + amount);
    }

}
