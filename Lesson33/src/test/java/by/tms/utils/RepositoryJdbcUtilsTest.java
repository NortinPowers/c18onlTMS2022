package by.tms.utils;

import by.tms.model.Product;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RepositoryJdbcUtilsTest {

    @Test
    void getQueryDependType() {
        Assertions.assertEquals("query and p.type='type' order by p.id", RepositoryJdbcUtils.getQueryDependType("type", "query"));
        Assertions.assertEquals("query order by p.id", RepositoryJdbcUtils.getQueryDependType("all", "query"));

    }

    @Test
    void isProductNotIncluded() {
        List<Product> products = List.of(Product.builder()
                                                .id(1L)
                                                .build());
        Assertions.assertFalse(RepositoryJdbcUtils.isProductNotIncluded(1L, products));
        Assertions.assertTrue(RepositoryJdbcUtils.isProductNotIncluded(2L, products));

    }

    @Test
    void getModifyCount() {
        Assertions.assertEquals(2, RepositoryJdbcUtils.getModifyCount(true, 1));
        Assertions.assertEquals(0, RepositoryJdbcUtils.getModifyCount(false, 1));
    }
}