package com.testsUnitaires;


import com.examfinal.examfinalprog2.entity.Orders;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class orderTest {

    @Test
    public void testGettersAndSetters() {
        Orders order = new Orders(1,LocalDate.of(2023,8,30),"Mvola",1);

        order.setId(1);
        order.setOrderDate(LocalDate.of(2023,8,30));
        order.setPayment("Mvola");
        order.setIdUser(1);

        assertEquals(1, order.getId());
        assertEquals(LocalDate.of(2023,8,30), order.getOrderDate());
        assertEquals("Mvola", order.getPayment());
        assertEquals(1, order.getIdUser());
    }
}

