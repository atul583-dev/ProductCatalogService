package com.ecomm.ProductCatalogService.utils;

import com.ecomm.ProductCatalogService.dtos.FakeStoreProductDto;
import com.ecomm.ProductCatalogService.dtos.ProductDto;
import com.ecomm.ProductCatalogService.models.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductMapper {

    private static final ObjectMapper mapper = new ObjectMapper();

    // Product -> ProductDto (e.g., for API response)
    public static ProductDto toDto(Product product) {
        if (product == null) return null;
        return mapper.convertValue(product, ProductDto.class);
    }

    // ProductDto -> Product (e.g., for saving to DB)
    public static Product toEntity(ProductDto dto) {
        if (dto == null) return null;
        return mapper.convertValue(dto, Product.class);
    }

    public static Product from(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setName(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImage());
        return product;
    }

    public static FakeStoreProductDto fromProductToFakeStoreProductDto(Product product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setTitle(product.getName());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setImage(product.getImageUrl());
        return fakeStoreProductDto;
    }


}
