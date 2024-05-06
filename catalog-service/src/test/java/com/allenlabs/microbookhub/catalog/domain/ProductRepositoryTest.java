package com.allenlabs.microbookhub.catalog.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest(
        properties = {
            "spring.test.database.replace=NONE",
            "spring.datasource.url=jdbc:tc:postgresql:16-alpine:///db",
        })
// @Import(ContainersConfig.class)
@Sql("/test-data.sql")
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void shouldGetAllProducts() {
        var products = productRepository.findAll();
        assertThat(products).hasSize(15);
    }
}
