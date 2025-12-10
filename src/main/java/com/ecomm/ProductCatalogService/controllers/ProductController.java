package com.ecomm.ProductCatalogService.controllers;

import com.ecomm.ProductCatalogService.dtos.ProductDto;
import com.ecomm.ProductCatalogService.models.Product;
import com.ecomm.ProductCatalogService.services.IProductService;
import com.ecomm.ProductCatalogService.utils.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/{id}")
    public ProductDto getProductDetails(@PathVariable Long id) {

        if (id < 0) {
            throw new IllegalArgumentException("Please pass product id greater than 0");
        }
        Product product = productService.getProductById(id);

        if (product == null) {
            return null;
        }
        return ProductMapper.toDto(product);
    }

    @GetMapping
    public List<ProductDto> getAllProducts() {

        List<ProductDto> productDtos = new ArrayList<>();
        List<Product> productList = productService.getAllProducts();

        for (Product p : productList) {
            productDtos.add(ProductMapper.toDto(p));
        }

        return productDtos;
    }

    @PutMapping("/{id}")
    public ProductDto replaceProduct(@PathVariable Long id, @RequestBody ProductDto productdto) {

        Product product = productService.replaceProduct(id, ProductMapper.toEntity(productdto));
        return ProductMapper.toDto(product);
    }

    @PatchMapping("/products/{id}")
    public ProductDto updateProduct(@PathVariable Long id,  @RequestBody Product product) {

        product.setName("IPhone 17");
        return null;
    }
}
