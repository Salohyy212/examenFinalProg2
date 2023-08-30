package com.examfinal.examfinalprog2.service;

import com.examfinal.examfinalprog2.entity.Orders;
import org.springframework.stereotype.Service;
import com.examfinal.examfinalprog2.repository.OrderCrud;
import java.sql.SQLException;
import java.util.List;

@Service
public class OrderService {
    private OrderCrud orderCrud;

    public OrderService(OrderCrud orderCrud) {
        System.out.println("Appel du constructeur de service");
        this.orderCrud = orderCrud;
    }

    public void insertOrder(Orders order) throws SQLException {
        orderCrud.insertOrder(order);
    }

    public Orders findOrderById(int id) throws SQLException {
        return orderCrud.findOrderById(id);
    }

    public List<Orders> findAllOrders() throws SQLException {
        return orderCrud.findAllOrders();
    }

    public boolean deleteOrder(int id) throws SQLException {
        return orderCrud.deleteOrder(id);
    }

    public boolean updateOrder(Orders orderUpdate) throws SQLException {
        return orderCrud.updateOrder(orderUpdate);
    }
}
