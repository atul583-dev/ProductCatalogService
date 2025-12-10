package com.ecomm.ProductCatalogService.services;

import com.ecomm.ProductCatalogService.dtos.ProductDto;
import com.ecomm.ProductCatalogService.models.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IProductService {

    public Product getProductById(Long id);

    public List<Product> getAllProducts();

    public Product updateProduct(Long id, Product product);

    public Product replaceProduct(@PathVariable Long id, @RequestBody Product product);
}
