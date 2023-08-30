package com.examfinal.examfinalprog2.service;

import com.examfinal.examfinalprog2.entity.ArticleType;
import org.springframework.stereotype.Service;
import com.examfinal.examfinalprog2.repository.ArticleTypeCrud;
import java.sql.SQLException;
import java.util.List;

@Service
public class ArticleTypeService {
    private ArticleTypeCrud articleTypeCrud;

    public ArticleTypeService(ArticleTypeCrud articleTypeCrud) {
        this.articleTypeCrud = articleTypeCrud;
    }

    public void insertArticleType(ArticleType articleType) throws SQLException {
        articleTypeCrud.insertArticleType(articleType);
    }

    public ArticleType findArticleTypeById(int id) throws SQLException {
        return articleTypeCrud.findArticleTypeById(id);
    }

    public List<ArticleType> findAllArticleTypes() throws SQLException {
        return articleTypeCrud.findAllArticleType();
    }

    public boolean deleteArticleType(int id) throws SQLException {
        return articleTypeCrud.deleteArticleType(id);
    }

    public boolean updateArticleType(ArticleType articleTypeUpdate) throws SQLException {
        return articleTypeCrud.updateArticleType(articleTypeUpdate);
    }
}
