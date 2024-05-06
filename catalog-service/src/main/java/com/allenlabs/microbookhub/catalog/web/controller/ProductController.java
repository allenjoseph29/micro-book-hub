package com.allenlabs.microbookhub.catalog.web.controller;

import com.allenlabs.microbookhub.catalog.domain.PagedResult;
import com.allenlabs.microbookhub.catalog.domain.Product;
import com.allenlabs.microbookhub.catalog.domain.ProductNotFoundException;
import com.allenlabs.microbookhub.catalog.domain.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
class ProductController {
    private final ProductService productService;

    @GetMapping
    PagedResult<Product> getProducts(@RequestParam(name = "page", defaultValue = "1") int pageNo) {
        return productService.getProducts(pageNo);
    }

    @GetMapping("/{code}")
    ResponseEntity<Product> getProductByCode(@PathVariable String code) {
        return productService.getProductByCode(code)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> ProductNotFoundException.withCode(code));
    }
}
