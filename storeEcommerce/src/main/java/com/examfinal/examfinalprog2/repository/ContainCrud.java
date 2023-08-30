package com.examfinal.examfinalprog2.repository;

import com.examfinal.examfinalprog2.entity.Contain;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class ContainCrud {
    // Obtenir l'instance de ConnectDB
    private final ConnectDB db = ConnectDB.getInstance();

    // Obtenir la connexion à la base de données
    private final Connection connection = db.getConnection();

    public void insertContain(Contain contain) {
        String insertQuery = "INSERT INTO contain (id, quantity, id_order, id_article) VALUES (?,?,?,?)";
        try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
            insertStatement.setInt(1, contain.getId());
            insertStatement.setInt(2, contain.getQuantity());
            insertStatement.setInt(3, contain.getIdOrder());
            insertStatement.setInt(4, contain.getIdArticle());
            int rowsAffected = insertStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Successful insertion of contain with id : " + contain.getId());
            } else {
                System.out.println("Failed to insert contain with id : " + contain.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Contain findContainById(int id) {
        String sql = "SELECT * FROM contain WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Contain(
                        resultSet.getInt("id"),
                        resultSet.getInt("quantity"),
                        resultSet.getInt("id_order"),
                        resultSet.getInt("id_article")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Contain> findAllContains() {
        List<Contain> containList = new ArrayList<>();
        String sql = "SELECT * FROM contain";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Contain contain = new Contain(
                        resultSet.getInt("id"),
                        resultSet.getInt("quantity"),
                        resultSet.getInt("id_order"),
                        resultSet.getInt("id_article")
                );
                containList.add(contain);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  containList;
    }

    public boolean deleteContain(int id) {
        String selectQuery = "SELECT * FROM contain WHERE id = ?";
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

        String deleteQuery = "DELETE FROM contain WHERE id = ?";
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


    public boolean updateContain(Contain containUpdate) {
        String updateQuery = "UPDATE contain SET quantity = ? WHERE id = ?";
        try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
            updateStatement.setInt(1, containUpdate.getQuantity());
            updateStatement.setInt(2, containUpdate.getId());
            int rowsAffected = updateStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
