package com.testsUnitaires;

import com.examfinal.examfinalprog2.entity.User;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class userTest {

    @Test
    public void testGettersAndSetters() {
        User user = new User(1, "Darby", "Bay", "Amborogony", "darby@example.com", "0324565372", LocalDate.now());

        user.setId(1);
        user.setFirstName("Darby");
        user.setLastName("Bay");
        user.setAdress("Amborogony");
        user.setEmail("darby@example.com");
        user.setPhone("0324565372");
        user.setCreationDate(LocalDate.now());

        assertEquals(1, user.getId());
        assertEquals("Darby", user.getFirstName());
        assertEquals("Bay", user.getLastName());
        assertEquals("Amborogony", user.getAdress());
        assertEquals("darby@example.com", user.getEmail());
        assertEquals("0324565372", user.getPhone());
        assertEquals(LocalDate.now(), user.getCreationDate());
    }
}
