package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.BeanFactory;

@SpringBootApplication
public class SpringToolApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SpringToolApplication.class, args);
//		System.out.println("Hello World");

//		ApplicationContext context = SpringApplication.run(SpringToolApplication.class, args);
//		Car car1 = context.getBean(Car.class);
//		Car car2 = context.getBean(Car.class);
//		System.out.println(car1);
//		System.out.println(car2);

//		Vechile vechile = context.getBean(Bike.class);
//		vechile.run();
		
		BeanFactory factory = SpringApplication.run(SpringToolApplication.class, args);
		Vechile vechile = factory.getBean("auto",Vechile.class);
		vechile.run();
	}
}
