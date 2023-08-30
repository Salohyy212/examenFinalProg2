package com.examfinal.examfinalprog2.entity;

public class ArticleType {
    private int id;
    private String articleTypeName;

    public ArticleType(int id, String articleTypeName) {
        this.id = id;
        this.articleTypeName = articleTypeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArticleTypeName() {
        return articleTypeName;
    }

    public void setArticleTypeName(String articleTypeName) {
        this.articleTypeName = articleTypeName;
    }

    @Override
    public String toString() {
        return "ArticleType{" +
                "id=" + id +
                ", articleTypeName='" + articleTypeName + '\'' +
                '}';
    }
}
