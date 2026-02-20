package com.capgemini.MockitoTask;

import java.util.List;

public class OrderManager {

    private OrderDao orderDao;

    public OrderManager(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    // 1️⃣ Get All Orders
    public List<Order> fetchAllOrders() {
        return orderDao.getAllOrders();
    }

    // 2️⃣ Add Order
    public boolean addNewOrder(Order order) {
        orderDao.logAction("Order Placed");
        return orderDao.addOrder(order);
    }

    // 3️⃣ Cancel Order
    public boolean cancelExistingOrder(int id) {
        orderDao.logAction("Order Cancelled");
        return orderDao.cancelOrder(id);
    }

    // Internal Logic Method
    public String checkOffer() {
        return "Regular Offer";
    }

    // 4️⃣ Process Orders
    public double processOrder(double price) {
        String offer = checkOffer();

        if (offer.equals("Festival Offer")) {
            return price * 0.80; // 20% discount
        } else {
            return price * 0.90; // 10% discount
        }
    }

    // 5️⃣ Static Discount Method
    public static double calculateDiscount(double price) {
        return price * 0.90;
    }
}
