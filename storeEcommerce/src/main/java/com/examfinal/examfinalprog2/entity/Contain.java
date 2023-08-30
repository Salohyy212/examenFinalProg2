package com.examfinal.examfinalprog2.entity;

public class Contain {
    private int id;
    private int quantity;
    private int idOrder;
    private int idArticle;

    public Contain(int id, int quantity, int idOrder, int idArticle) {
        this.id = id;
        this.quantity = quantity;
        this.idOrder = idOrder;
        this.idArticle = idArticle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    @Override
    public String toString() {
        return "Contain{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", idOrder=" + idOrder +
                ", idArticle=" + idArticle +
                '}';
    }
}
