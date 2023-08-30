package com.testCrud;

import com.examfinal.examfinalprog2.entity.Articles;
import com.examfinal.examfinalprog2.repository.ArticleCrud;

import java.util.List;

public class ArticleCrudTest {
    public static void main(String[] args) {
        ArticleCrud articleCrud = new ArticleCrud();

        // Test insertion of an article
        Articles newArticle = new Articles(1, "short", 7000.0, 10, 1);
        articleCrud.insertArticle(newArticle);

        // Test finding an article by ID
        Articles foundArticle = articleCrud.findArticleById(1); // Utilisez l'ID de l'article que vous venez d'insérer
        if (foundArticle != null) {
            System.out.println("Article found: " + foundArticle.toString());
        } else {
            System.out.println("Article not found.");
        }

        // Test updating an article
        Articles updatedArticle = new Articles(1, "short", 8000.0, 5, 1); // Utilisez le bon ID
        boolean updated = articleCrud.updateArticle(updatedArticle);
        if (updated) {
            System.out.println("Article updated successfully.");
        } else {
            System.out.println("Failed to update the article.");
        }

        // Test deleting an article
        boolean deleted = articleCrud.deleteArticle(1); // Utilisez le bon ID
        if (deleted) {
            System.out.println("Article deleted successfully.");
        } else {
            System.out.println("The article does not exist.");
        }

        // Test finding all articles
        List<Articles> articleList = articleCrud.findAllArticles();

        if (articleList.isEmpty()) {
            System.out.println("There are no articles.");
        } else {
            System.out.println("All Articles:");
            for (Articles article : articleList) {
                System.out.println(article.toString());
            }
        }
    }
}
