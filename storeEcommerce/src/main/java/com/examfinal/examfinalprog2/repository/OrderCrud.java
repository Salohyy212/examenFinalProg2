package com.examfinal.examfinalprog2.repository;

import com.examfinal.examfinalprog2.entity.Orders;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;

import java.util.List;


@Repository
public class OrderCrud {
    private final ConnectDB db = ConnectDB.getInstance();
    private final Connection connection = db.getConnection();

    public void insertOrder(Orders order) {
        String insertQuery = "INSERT INTO orders (id, order_date, payment) VALUES (?,?,?)";
        try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
            insertStatement.setInt(1, order.getId());
            insertStatement.setDate(2, java.sql.Date.valueOf(order.getOrderDate()));
            insertStatement.setString(3, order.getPayment());
            insertStatement.setInt(4, order.getIdUser());
            int rowsAffected = insertStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Successful insertion of order with id : " + order.getId());
            } else {
                System.out.println("Failed to insert order with id : " + order.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Orders findOrderById(int id) {
        String sql = "SELECT * FROM orders WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Orders(
                        resultSet.getInt("id"),
                        resultSet.getDate("order_date").toLocalDate(),
                        resultSet.getString("payment"),
                        resultSet.getInt("id_user")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Orders> findAllOrders() {
        List<Orders> orderList = new ArrayList<>();
        String sql = "SELECT * FROM orders";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Orders order = new Orders(
                        resultSet.getInt("id"),
                        resultSet.getDate("order_date").toLocalDate(),
                        resultSet.getString("payment"),
                        resultSet.getInt("id_user")
                );
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    public boolean deleteOrder(int id) {
        String selectQuery = "SELECT * FROM Orders WHERE id = ?";
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

        String deleteQuery = "DELETE FROM Orders WHERE id = ?";
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


    public boolean updateOrder(Orders orderUpdate) {
        String updateQuery = "UPDATE orders SET order_date = ?, payment = ? WHERE id = ?";
        try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
            updateStatement.setDate(1, Date.valueOf(orderUpdate.getOrderDate()));
            updateStatement.setString(2, orderUpdate.getPayment());
            updateStatement.setInt(3, orderUpdate.getId());
            int rowsAffected = updateStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
