package de.slash.productsservice;

import de.slash.productsservice.product.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureHttpGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.HttpGraphQlTester;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest()
@ActiveProfiles("test")
@Transactional
@AutoConfigureHttpGraphQlTester
class ProductControllerIT {

    @Autowired
    HttpGraphQlTester httpGraphQlTester;

    @Test
    void getProduct() {
        Product product = httpGraphQlTester.document(
                        "query GetProduct {" +
                                "    getProduct(id: \"2\") {" +
                                "        id" +
                                "        name" +
                                "        price" +
                                "    }" +
                                "}")
                .execute()
                .errors()
                .verify()
                .path("getProduct")
                .entity(Product.class)
                .get();
        assertNotNull(product);
        assertEquals(2L, product.getId());
        assertEquals("The Dark Forest", product.getName());
        assertEquals(BigDecimal.valueOf(10.99), product.getPrice());
    }
}
