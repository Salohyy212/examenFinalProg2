package com.testCrud;

import com.examfinal.examfinalprog2.entity.Contain;
import com.examfinal.examfinalprog2.repository.ContainCrud;
import java.util.List;

public class ContainCrudTest {
    public static void main(String[] args) {
        ContainCrud containCrud = new ContainCrud();

        // Test insertion of a contain
        Contain newContain = new Contain(1, 5, 1, 1);
        containCrud.insertContain(newContain);

        // Test finding a contain by ID
        Contain foundContain = containCrud.findContainById(1);
        if (foundContain != null) {
            System.out.println("Contain found: " + foundContain.toString());
        } else {
            System.out.println("Contain not found.");
        }

        // Test updating a contain
        Contain updatedContain = new Contain(1, 10, 1, 1);
        boolean updated = containCrud.updateContain(updatedContain);
        if (updated) {
            System.out.println("Contain updated successfully.");
        } else {
            System.out.println("Failed to update the contain.");
        }

        // Test deleting a contain
        boolean deleted = containCrud.deleteContain(1);
        if (deleted) {
            System.out.println("Contain deleted successfully.");
        } else {
            System.out.println("Failed to delete the contain.");
        }

        // Test finding all contains
        List<Contain> containList = containCrud.findAllContains();

        if (containList.isEmpty()) {
            System.out.println("There are no contains.");
        } else {
            System.out.println("All Contains:");
            for (Contain contain : containList) {
                System.out.println(contain.toString());
            }
        }
    }
}
