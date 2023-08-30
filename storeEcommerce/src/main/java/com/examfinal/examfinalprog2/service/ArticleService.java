package com.examfinal.examfinalprog2.service;

import com.examfinal.examfinalprog2.entity.Articles;
import org.springframework.stereotype.Service;
import com.examfinal.examfinalprog2.repository.ArticleCrud;

import java.sql.SQLException;
import java.util.List;

@Service
public class ArticleService {
    private ArticleCrud articleCrud;

    public ArticleService(ArticleCrud articleCrud) {
        this.articleCrud = articleCrud;
    }

    public void insertArticle(Articles article) throws SQLException {
        articleCrud.insertArticle(article);
    }

    public Articles findArticleById(int id) throws SQLException {
        return articleCrud.findArticleById(id);
    }

    public List<Articles> findAllArticles() throws SQLException {
        return articleCrud.findAllArticles();
    }

    public boolean deleteArticle(int id) throws SQLException {
        return articleCrud.deleteArticle(id);
    }

    public boolean updateArticle(Articles articleUpdate) throws SQLException {
        return articleCrud.updateArticle(articleUpdate);
    }
}
