package com.examfinal.examfinalprog2.controller;

import com.examfinal.examfinalprog2.entity.User;
import org.springframework.web.bind.annotation.*;
import com.examfinal.examfinalprog2.service.UserService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> getAllUsers() throws SQLException {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) throws SQLException {
        return userService.getUserById(id);
    }

    @PostMapping("/")
    public void addUser(@RequestBody User user) throws SQLException {
        userService.insertUser(user); // Appel de la méthode insertUser du service avec un objet User en entrée
    }

    @PutMapping("/{id}") // Cette méthode répond aux requêtes PUT vers "/api/users/{id}"
    public void updateUser(@RequestBody User userUpdate) throws SQLException {
        userService.updateUser(userUpdate);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) throws SQLException {
        userService.deleteUser(id);
    }
}
