package com.springcore.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Demo13SpringcoreApplication {

	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(Demo13SpringcoreApplication.class, args);

		ConstructorInjectionService constructorService = context.getBean(ConstructorInjectionService.class);
		constructorService.makePayment();

		SetterInjectionService setterService = context.getBean(SetterInjectionService.class);
		setterService.makePayment();

		FieldInjectionService fieldService = context.getBean(FieldInjectionService.class);
		fieldService.makePayment();
		
	}

}
