package com.examfinal.examfinalprog2.repository;

import com.examfinal.examfinalprog2.entity.ArticleType;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class ArticleTypeCrud {
    // Obtenir l'instance de ConnectDB
    private final ConnectDB db = ConnectDB.getInstance();

    // Obtenir la connexion à la base de données
    private final Connection connection = db.getConnection();

    public void insertArticleType(ArticleType articleType) {
        String insertQuery = "INSERT INTO article_type (id, name) VALUES (?,?)";
        try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
            insertStatement.setInt(1, articleType.getId());
            insertStatement.setString(2, articleType.getArticleTypeName());
            int rowsAffected = insertStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Successful insertion of article type with id : " + articleType.getId());
            } else {
                System.out.println("Failed to insert article type with id : " + articleType.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ArticleType findArticleTypeById(int id) {
        String sql = "SELECT * FROM article_type WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new ArticleType(
                        resultSet.getInt("id"),
                        resultSet.getString("name")


                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ArticleType> findAllArticleType() {
        List<ArticleType> articleTypeList = new ArrayList<>();
        String sql = "SELECT * FROM article_type";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                ArticleType articleType = new ArticleType(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
                articleTypeList.add(articleType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  articleTypeList;
    }

    public boolean deleteArticleType(int id) {
        String selectQuery = "SELECT * FROM article_type WHERE id = ?";
        try (PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
            selectStatement.setInt(1, id);
            ResultSet resultSet = selectStatement.executeQuery();
            if (!resultSet.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        String deleteQuery = "DELETE FROM article_type WHERE id = ?";
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


    public boolean updateArticleType(ArticleType articleTypeUpdate) {
        String updateQuery = "UPDATE article_type SET name = ? WHERE id = ?";
        try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
            updateStatement.setString(1, articleTypeUpdate.getArticleTypeName());
            updateStatement.setInt(2, articleTypeUpdate.getId());

            int rowsAffected = updateStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
