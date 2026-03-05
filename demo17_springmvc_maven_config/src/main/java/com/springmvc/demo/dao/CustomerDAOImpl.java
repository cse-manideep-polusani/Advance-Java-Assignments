package com.springmvc.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.demo.model.Customer;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Customer customer) {
        if (customer.getId() == null) {
            entityManager.persist(customer);
        } else {
            entityManager.merge(customer);
        }
    }

    @Override
    public List<Customer> findAll() {
        return entityManager
                .createQuery("from Customer", Customer.class)
                .getResultList();
    }

    @Override
    public Customer findById(Long id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public void delete(Long id) {
        Customer customer = findById(id);
        if (customer != null) {
            entityManager.remove(customer);
        }
    }
}