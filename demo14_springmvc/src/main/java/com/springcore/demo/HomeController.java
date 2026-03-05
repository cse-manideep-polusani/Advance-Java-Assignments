package com.springcore.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String home(Model model) {
		User user = new User(1,"Manideep","Warangal");
		model.addAttribute("user",user);
		return "Home";
	}
	
	
	@GetMapping("/login")
	public String login() {
		return "Login";
	}
}
