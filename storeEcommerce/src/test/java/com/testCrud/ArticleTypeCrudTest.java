package com.testCrud;

import com.examfinal.examfinalprog2.entity.ArticleType;
import com.examfinal.examfinalprog2.repository.ArticleTypeCrud;

import java.util.List;

public class ArticleTypeCrudTest {
    public static void main(String[] args) {
        ArticleTypeCrud articleTypeCrud = new ArticleTypeCrud();

        // Test insertion of an article type
        ArticleType newArticleType = new ArticleType(1, "Accessories");
        articleTypeCrud.insertArticleType(newArticleType);

        // Test finding an article type by ID
        ArticleType foundArticleType = articleTypeCrud.findArticleTypeById(1);
        if (foundArticleType != null) {
            System.out.println("Article type found: " + foundArticleType.toString());
        } else {
            System.out.println("Article type not found.");
        }

        // Test updating an article type
        ArticleType updatedArticleType = new ArticleType(1, "Clothing");
        boolean updated = articleTypeCrud.updateArticleType(updatedArticleType);
        if (updated) {
            System.out.println("Article type updated successfully.");
        } else {
            System.out.println("Failed to update the article type.");
        }

        // Test deleting an article type
        boolean deleted = articleTypeCrud.deleteArticleType(2);
        if (deleted) {
            System.out.println("Article type deleted successfully.");
        } else {
            System.out.println("Failed to delete the article type.");
        }

        // Test finding all article types
        List<ArticleType> articleTypeList = articleTypeCrud.findAllArticleType();

        if (articleTypeList.isEmpty()) {
            System.out.println("There are no article types.");
        } else {
            System.out.println("All Article Types:");
            for (ArticleType articleType : articleTypeList) {
                System.out.println(articleType.toString());
            }
        }
    }
}
