package com.testsUnitaires;

import com.examfinal.examfinalprog2.entity.ArticleType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class articleTypeTest {

    @Test
    public void testGettersAndSetters() {
        ArticleType articleType = new ArticleType(1,"Shoe");

        articleType.setId(1);
        articleType.setArticleTypeName("Shoe");

        assertEquals(1, articleType.getId());
        assertEquals("Shoe", articleType.getArticleTypeName());
    }
}

