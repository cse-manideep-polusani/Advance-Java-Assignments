package com.customermanagementsystem.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.customermanagementsystem.model.Customer;
import com.customermanagementsystem.service.CustomerService;


@Controller
public class CustomerController {
	private CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService=customerService;
	}
	
	
    @GetMapping("/addCustomer")
    public String addCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "addCustomer";
    }
    
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }
    
    @GetMapping("/customers")
    public String showCustomers(Model model){
    	List<Customer> customerList = customerService.getAllCustomers();
    	model.addAttribute("customers",customerList);
    	return "customers";
    }
}
