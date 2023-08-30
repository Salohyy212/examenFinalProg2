package com.examfinal.examfinalprog2.entity;

public class Articles {

    private int id;
    private String articleName;
    private Double price;
    private int stock;
    private int idArticleType;

    public Articles(int id , String articleName, Double price, int stock, int idArticleType) {
        this.id = id;
        this.articleName = articleName;
        this.price = price;
        this.stock = stock;
        this.idArticleType = idArticleType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getIdArticleType() {
        return idArticleType;
    }

    public void setIdArticleType(int idArticleType) {
        this.idArticleType = idArticleType;
    }

    @Override
    public String toString() {
        return "Articles{" +
                "id=" + id +
                ", articleName='" + articleName + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", idArticleType=" + idArticleType +
                '}';
    }
}
