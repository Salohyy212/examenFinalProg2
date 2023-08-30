package com.examfinal.examfinalprog2.controller;

import com.examfinal.examfinalprog2.entity.Articles;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.examfinal.examfinalprog2.service.ArticleService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {
    private ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/")
    public List<Articles> getAllArticles() throws SQLException {
        return articleService.findAllArticles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Articles> getArticleById(@PathVariable int id) throws SQLException {
        Articles article = articleService.findArticleById(id);
        if (article != null) {
            return new ResponseEntity<>(article, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void addArticle(@RequestBody Articles article) throws SQLException {
        articleService.insertArticle(article);
    }

    @PutMapping("/{id}")
    public void updateArticle(@RequestBody Articles articleUpdate) throws SQLException {
        articleService.updateArticle(articleUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable int id) throws SQLException {
        articleService.deleteArticle(id);
    }
}

