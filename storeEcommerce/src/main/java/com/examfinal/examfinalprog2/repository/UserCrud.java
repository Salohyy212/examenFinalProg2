package com.examfinal.examfinalprog2.repository;

import com.examfinal.examfinalprog2.entity.User;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class UserCrud {
    private final ConnectDB db = ConnectDB.getInstance();
    private final Connection connection = db.getConnection();
    public User insertUser(User user) {
        String insertQuery = "INSERT INTO \"user\" (id, first_name, last_name, adress, email, phone, creation_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
            insertStatement.setInt(1, user.getId());
            insertStatement.setString(2, user.getFirstName());
            insertStatement.setString(3, user.getLastName());
            insertStatement.setString(4, user.getAdress());
            insertStatement.setString(5, user.getEmail());
            insertStatement.setString(6, user.getPhone());
            insertStatement.setDate(7, Date.valueOf(user.getCreationDate()));

            int rowsAffected = insertStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Successful insertion of user with id: " + user.getId());
            } else {
                System.out.println("Failed to insert user with id: " + user.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    public User findUserById(int id) {
        String sql = "SELECT * FROM \"user\" WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("adress"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getDate("creation_date").toLocalDate()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> findAllUsers() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM \"user\"";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("adress"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getDate("creation_date").toLocalDate()
                );
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public boolean deleteUser(int id) {
        String selectQuery = "SELECT * FROM \"user\" WHERE id = ?";
        try (PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
            selectStatement.setInt(1, id);
            ResultSet resultSet = selectStatement.executeQuery();
            if (!resultSet.next()) {
                System.out.println("The record with the id : "+ id +", does not exist.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        String deleteQuery = "DELETE FROM \"user\" WHERE id = ?";
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


    public boolean updateUser(User userUpdate) {
        String updateQuery = "UPDATE \"user\" SET first_name = ?, last_name = ?, adress = ?, email = ?, phone = ?, creation_date = ? WHERE id = ?";
        try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
            updateStatement.setString(1, userUpdate.getFirstName());
            updateStatement.setString(2, userUpdate.getLastName());
            updateStatement.setString(3, userUpdate.getAdress());
            updateStatement.setString(4, userUpdate.getEmail());
            updateStatement.setString(5, userUpdate.getPhone());
            updateStatement.setDate(6, Date.valueOf(userUpdate.getCreationDate()));
            updateStatement.setInt(7, userUpdate.getId());

            int rowsAffected = updateStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}



