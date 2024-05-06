package com.allenlabs.microbookhub.catalog.web.controller;

import com.allenlabs.microbookhub.catalog.domain.PagedResult;
import com.allenlabs.microbookhub.catalog.domain.Product;
import com.allenlabs.microbookhub.catalog.domain.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
class ProductController {
    private final ProductService productService;

    @GetMapping
    PagedResult<Product> getProducts(@RequestParam(name = "page", defaultValue = "1") int pageNo) {
        return productService.getProducts(pageNo);
    }
}
