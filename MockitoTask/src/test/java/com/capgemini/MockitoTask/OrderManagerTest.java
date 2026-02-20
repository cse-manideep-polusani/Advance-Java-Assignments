package com.capgemini.MockitoTask;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.MockitoTask.Order;
import com.capgemini.MockitoTask.OrderDao;
import com.capgemini.MockitoTask.OrderManager;

class OrderManagerTest {

    @Mock
    private OrderDao dao;

    @InjectMocks
    private OrderManager manager;

    private Order order1;
    private Order order2;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);

        order1 = new Order(1, "Dominos", "Pizza", 500);
        order2 = new Order(2, "KFC", "Burger", 300);
    }

    @Test
    void testFetchAllOrders() {

        when(dao.getAllOrders())
                .thenReturn(Arrays.asList(order1, order2));

        List<Order> list = manager.fetchAllOrders();

        assertEquals(2, list.size());
        verify(dao).getAllOrders();
    }

    // 2️⃣ Add Order
    @Test
    void testAddOrder() {

        when(dao.addOrder(order1)).thenReturn(true);

        boolean result = manager.addNewOrder(order1);

        assertTrue(result);
        verify(dao).addOrder(order1);
        verify(dao).logAction("Order Placed");
    }

    // 3️⃣ Cancel Order
    @Test
    void testCancelOrder() {

        when(dao.cancelOrder(1)).thenReturn(true);

        boolean result = manager.cancelExistingOrder(1);

        assertTrue(result);
        verify(dao).cancelOrder(1);
        verify(dao).logAction("Order Cancelled");
    }

    // 4️⃣ Static Discount Calculation
    @Test
    void testStaticDiscount() {

        double result =
                OrderManager.calculateDiscount(1000);

        assertEquals(900, result);
    }

    // 5️⃣ Final Method Testing
    @Test
    void testFinalMethod() {

        OrderDao realDao = new OrderDao();

        String dbInfo = realDao.getDatabaseInfo();

        assertEquals("Connected to MySQL DB", dbInfo);
    }

    // 6️⃣ Void Method Testing
    @Test
    void testVoidLogging() {

        doNothing().when(dao)
                .logAction("Order Placed");

        manager.addNewOrder(order1);

        verify(dao).logAction("Order Placed");
    }

    // 7️⃣ Spy – Process Order
    @Test
    void testProcessOrder_FestivalOffer() {

        OrderManager spyManager =
                spy(new OrderManager(dao));

        doReturn("Festival Offer")
                .when(spyManager)
                .checkOffer();

        double price = spyManager.processOrder(1000);

        assertEquals(800, price);
    }
}