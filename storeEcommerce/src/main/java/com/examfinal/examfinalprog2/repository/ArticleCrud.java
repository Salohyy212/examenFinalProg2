package com.examfinal.examfinalprog2.repository;

import com.examfinal.examfinalprog2.entity.Articles;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class ArticleCrud {
    //// Obtenir l'instance de ConnectDB
    private final ConnectDB db = ConnectDB.getInstance();

    // Obtenir la connexion à la base de données
    private final Connection connection = db.getConnection();

    public void insertArticle(Articles article) {
        String insertQuery = "INSERT INTO articles(id, article_name, price, stock, id_article_type) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
            insertStatement.setInt(1, article.getId());
            insertStatement.setString(2, article.getArticleName());
            insertStatement.setDouble(3, article.getPrice());
            insertStatement.setInt(4, article.getStock());
            insertStatement.setInt(5, article.getIdArticleType());
            int rowsAffected = insertStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Successful insertion of article with ID " + article.getId());
            } else {
                System.out.println("Failed to insert article with ID " + article.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Articles findArticleById(int id) {
        String sql = "SELECT * FROM articles WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Articles(
                        resultSet.getInt("id"),
                        resultSet.getString("article_name"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("stock"),
                        resultSet.getInt("id_article_type")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Articles> findAllArticles() {
        List<Articles> articleList = new ArrayList<>();
        String sql = "SELECT * FROM articles";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Articles article = new Articles(
                        resultSet.getInt("id"),
                        resultSet.getString("article_name"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("stock"),
                        resultSet.getInt("id_article_type")
                );
                articleList.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articleList;
    }

    public boolean deleteArticle(int id) {
        String selectQuery = "SELECT * FROM articles WHERE id = ?";
        try (PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
            selectStatement.setInt(1, id);
            ResultSet resultSet = selectStatement.executeQuery();
            if (!resultSet.next()) {
                System.out.println("The record with the ID : "+ id +" does not exist.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        String deleteQuery = "DELETE FROM articles WHERE id = ?";
        try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
            deleteStatement.setInt(1, id);
            int rowsAffected = deleteStatement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    public boolean updateArticle(Articles articleUpdate) {
        String updateQuery = "UPDATE articles SET article_name = ?, price = ? WHERE id = ?";
        try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
            updateStatement.setString(1, articleUpdate.getArticleName());
            updateStatement.setDouble(2, articleUpdate.getPrice());
            updateStatement.setInt(3, articleUpdate.getId());
            int rowsAffected = updateStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}

