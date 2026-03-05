package com.springmvc.demo.dao;

import java.util.List;
import com.springmvc.demo.model.Customer;

public interface CustomerDAO {

    void save(Customer customer);

    List<Customer> findAll();

    Customer findById(Long id);

    void delete(Long id);
}