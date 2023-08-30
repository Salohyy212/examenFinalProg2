package com.examfinal.examfinalprog2.service;

import com.examfinal.examfinalprog2.entity.User;
import org.springframework.stereotype.Service;
import com.examfinal.examfinalprog2.repository.UserCrud;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {
    private UserCrud userCrud;

    public UserService(UserCrud userCrud) {
        System.out.println("Appel du constructeur de service");
        this.userCrud = userCrud;
    }

    // le métier de votre application : tous les traitements de votre thème.

    public List<User> getAllUsers() throws SQLException {
        return userCrud.findAllUsers();
    }

    public User getUserById(int id) throws SQLException {
        return userCrud.findUserById(id);
    }

    public void insertUser(User user) throws SQLException {
        userCrud.insertUser(user);
    }

    public boolean deleteUser(int id) throws SQLException {
        return userCrud.deleteUser(id);
    }

    public boolean updateUser(User userUpdate) throws SQLException {
        return userCrud.updateUser(userUpdate);
    }

}
