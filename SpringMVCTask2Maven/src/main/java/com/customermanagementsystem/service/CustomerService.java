package com.customermanagementsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.customermanagementsystem.model.Customer;
import com.customermanagementsystem.repository.CustomerRepository;

@Service
public class CustomerService {
	private CustomerRepository customerRepository;
	
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
