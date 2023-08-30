package com.testCrud;

import com.examfinal.examfinalprog2.entity.Orders;
import com.examfinal.examfinalprog2.repository.OrderCrud;

import java.time.LocalDate;
import java.util.List;

public class OrderCrudTest {
    public static void main(String[] args) {
        OrderCrud orderCrud = new OrderCrud();

        // Test insertion of an order
        Orders orderUpdated = new Orders(1, LocalDate.of(2023, 9, 24), "Credit Card",1);
        orderCrud.insertOrder(orderUpdated);

        // Test finding an order by ID
        Orders foundOrder = orderCrud.findOrderById(2);
        if (foundOrder != null) {
            System.out.println("Order found: " + foundOrder.toString());
        } else {
            System.out.println("Order not found.");
        }

        // Test updating an order
        Orders orderUpdate = new Orders(1, LocalDate.of(2023, 8, 25), "Mvola",1);
        boolean updated = orderCrud.updateOrder(orderUpdate);

        if (updated) {
            System.out.println("Order updated successfully.");
        } else {
            System.out.println("Failed to update the order.");
        }

        // Test deleting an order
        boolean deleted = orderCrud.deleteOrder(2);
        if (deleted) {
            System.out.println("Order deleted successfully.");
        }

        // Test finding all orders
        List<Orders> allOrders = orderCrud.findAllOrders();

        if (allOrders.isEmpty()) {
            System.out.println("There are no orders.");
        } else {
            System.out.println("All Orders:");
            for (Orders order : allOrders) {
                System.out.println(order.toString());
            }
        }

    }
}
