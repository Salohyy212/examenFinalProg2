package com.examfinal.examfinalprog2.controller;

import com.examfinal.examfinalprog2.entity.ArticleType;
import org.springframework.web.bind.annotation.*;
import com.examfinal.examfinalprog2.service.ArticleTypeService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/articletypes")
public class ArticleTypeController {
    private ArticleTypeService articleTypeService;

    public ArticleTypeController(ArticleTypeService articleTypeService) {
        this.articleTypeService = articleTypeService;
    }

    @GetMapping("/")
    public List<ArticleType> getAllArticleTypes() throws SQLException {
        return articleTypeService.findAllArticleTypes();
    }

    @GetMapping("/{id}")
    public ArticleType getArticleTypeById(@PathVariable int id) throws SQLException {
        return articleTypeService.findArticleTypeById(id);
    }

    @PostMapping("/")
    public void addArticleType(@RequestBody ArticleType articleType) throws SQLException {
        articleTypeService.insertArticleType(articleType);
    }

    @PutMapping("/{id}")
    public void updateArticleType(@RequestBody ArticleType articleTypeUpdate) throws SQLException {
        articleTypeService.updateArticleType(articleTypeUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteArticleType(@PathVariable int id) throws SQLException {
        articleTypeService.deleteArticleType(id);
    }
}

