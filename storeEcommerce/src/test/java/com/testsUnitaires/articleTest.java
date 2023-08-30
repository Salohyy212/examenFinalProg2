package com.testsUnitaires;

import com.examfinal.examfinalprog2.entity.Articles;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class articleTest {

    @Test
    public void testGettersAndSetters() {
        Articles article = new Articles(1,"Air jordan",15000.0,19,1);

        article.setId(1);
        article.setArticleName("Air jordan");;
        article.setPrice(15000.0);
        article.setStock(19);
        article.setIdArticleType(1);

        assertEquals(1, article.getId());
        assertEquals("Air jordan", article.getArticleName());
        assertEquals(15000.0, article.getPrice());
        assertEquals(19, article.getStock());
        assertEquals(1, article.getIdArticleType());
    }
}

