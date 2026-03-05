package com.springmvc.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.demo.dao.CustomerDAO;
import com.springmvc.demo.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public void saveCustomer(Customer customer) {
        customerDAO.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDAO.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerDAO.findById(id);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerDAO.delete(id);
    }
}