package com.capgemini.MockitoTask;

import java.util.ArrayList;
import java.util.List;



public class OrderDao {

    public List<Order> getAllOrders() {
        return new ArrayList<>(); // DB simulation
    }

    public boolean addOrder(Order order) {
        return true;
    }

    public boolean cancelOrder(int orderId) {
        return true;
    }

    // Final Method
    public final String getDatabaseInfo() {
        return "Connected to MySQL DB";
    }

    // Void Method
    public void logAction(String action) {
        System.out.println("LOG: " + action);
    }
}