package com.allenlabs.microbookhub.catalog.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
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

    @Test
    void shouldGetProductByCode() {
        var product = productRepository.findByCode("P100").orElseThrow();
        assertThat(product.getCode()).isEqualTo("P100");
        assertThat(product.getName()).isEqualTo("The Hunger Games");
        assertThat(product.getDescription()).isEqualTo("Winning will make you famous. Losing means certain death...");
        assertThat(product.getPrice()).isEqualTo(new BigDecimal("34.0"));
    }

    @Test
    void shouldReturnEmptyWhenProductNotExists() {
        var product = productRepository.findByCode("invalid-code");
        assertThat(product).isEmpty();
    }
}
