package com.springmvc.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.springmvc.demo.model.Customer;
import com.springmvc.demo.service.CustomerService;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @GetMapping("/")
    public String home() {
        return "redirect:/customers";
    }

    // READ - List all customers
    @GetMapping("/customers")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customer-list";
    }

    // CREATE - Show form
    @GetMapping("/addCustomer")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    // SAVE (Create & Update)
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    // UPDATE - Show edit form
    @GetMapping("/editCustomer/{id}")
    public String editCustomer(@PathVariable Long id, Model model) {
        model.addAttribute("customer",
                customerService.getCustomerById(id));
        return "customer-form";
    }

    // DELETE
    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }
}