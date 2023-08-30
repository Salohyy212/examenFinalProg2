package com.testCrud;

import com.examfinal.examfinalprog2.entity.User;
import com.examfinal.examfinalprog2.repository.UserCrud;

import java.time.LocalDate;
import java.util.List;

public class UserCrudTest {
    public static void main(String[] args) {
        UserCrud userCrud = new UserCrud();

        // Test insertion of a user
        User user = new User(1, "Vali", "Zeram", "Besarety", "vali@email.com", "0324291477", LocalDate.now());
        userCrud.insertUser(user);

        // Test finding a user by ID
        User foundUser = userCrud.findUserById(2);
        if (foundUser != null) {
            System.out.println("User found: " + foundUser.toString());
        } else {
            System.out.println("User not found.");
        }

        // Test updating a user
        User updatedUser = new User(1, "lafatra", "Zeram", "Tanambao", "lafatra@email.com", "0324567589", LocalDate.now());
        boolean updated = userCrud.updateUser(updatedUser);

        if (updated) {
            System.out.println("User updated successfully.");
        } else {
            System.out.println("Failed to update the user.");
        }

        // Test deleting a user
        boolean deleted = userCrud.deleteUser(2);
        if (deleted) {
            System.out.println("User deleted successfully.");
        }

        // Test finding all users
        List<User> userList = userCrud.findAllUsers();
        if (userList.isEmpty()) {
            System.out.println("There are no users.");
        } else {
            System.out.println("All Users:");
            for (User u : userList) {
                System.out.println(u.toString());
            }
        }

    }
}
