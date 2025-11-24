package com.ecomm.ProductCatalogService.controllers;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    public Product getProductDetails(Long id) {
        Product product = new Product();
        product.setId(id);
        return product;
    }
}
