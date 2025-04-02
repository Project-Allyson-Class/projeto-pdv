package com.pdv.demo.core.products;

import com.pdv.demo.application.products.dtos.ProductDto;
import com.pdv.demo.core.products.entities.Product;

import java.util.List;
import java.util.UUID;

public interface IProductsUseCase {

    Product create(ProductDto dto);

    List<Product> getAll();

    Product getById(UUID id);

    Product update(ProductDto dto);

    void delete(UUID id);
}
