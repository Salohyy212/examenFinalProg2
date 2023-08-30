package com.examfinal.examfinalprog2.entity;

import java.time.LocalDate;

public class Orders {
    private int id;
    private LocalDate orderDate;
    private String payment;
    private int idUser ;

    public Orders(int id, LocalDate orderDate, String payment, int idUser) {
        this.id = id;
        this.orderDate = orderDate;
        this.payment = payment;
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getOrder_date() {
        return orderDate;
    }

    public void setOrder_date(LocalDate order_date) {
        this.orderDate = order_date;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", order_date=" + orderDate +
                ", payment='" + payment + ", idUser="  + idUser +
                '}';
    }
}

