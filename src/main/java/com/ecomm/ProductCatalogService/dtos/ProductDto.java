package com.ecomm.ProductCatalogService.dtos;

import com.ecomm.ProductCatalogService.models.State;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {
    Long id;
    String name;
    String description;
    String imageUrl;
    Double price;
    Date createdAt;
    Date lastUpdatedAt;
    State state;
}
