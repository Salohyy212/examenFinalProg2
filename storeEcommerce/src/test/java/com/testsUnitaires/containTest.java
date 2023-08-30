package com.testsUnitaires;

import com.examfinal.examfinalprog2.entity.Contain;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class containTest {

    @Test
    public void testGettersAndSetters() {
        Contain contains = new Contain(1,5,1,1);

        contains.setId(1);
        contains.setQuantity(5);
        contains.setIdOrder(1);
        contains.setIdArticle(1);

        assertEquals(1, contains.getId());
        assertEquals(5, contains.getQuantity());
        assertEquals(1, contains.getIdOrder());
        assertEquals(1, contains.getIdOrder());
    }
}
