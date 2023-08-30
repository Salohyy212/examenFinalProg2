package com.examfinal.examfinalprog2.controller;

import com.examfinal.examfinalprog2.entity.Orders;
import org.springframework.web.bind.annotation.*;
import com.examfinal.examfinalprog2.service.OrderService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/")
    public List<Orders> getAllOrders() throws SQLException {
        return orderService.findAllOrders();
    }

    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable int id) throws SQLException {
        return orderService.findOrderById(id);
    }

    @PostMapping("/")
    public void addOrder(@RequestBody Orders order) throws SQLException {
        orderService.insertOrder(order);
    }

    @PutMapping("/{id}")
    public void updateOrder(@RequestBody Orders orderUpdate) throws SQLException {
        orderService.updateOrder(orderUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) throws SQLException {
        orderService.deleteOrder(id);
    }
}

