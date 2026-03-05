package com.springmvc.demo.service;

import java.util.List;
import com.springmvc.demo.model.Customer;

public interface CustomerService {

    void saveCustomer(Customer customer);

    List<Customer> getAllCustomers();

    Customer getCustomerById(Long id);

    void deleteCustomer(Long id);
}