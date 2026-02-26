package com.springcore.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringTool1Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringTool1Application.class, args);
		Car car = context.getBean(Car.class);
		car.drive();
	}

}
