package com.pdv.demo.core.products.entities;

import com.pdv.demo.application.products.dtos.ProductDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
    private UUID id;

    @NotNull
    @NotBlank
    @Schema(example = "Produto Exemplo")
    private String name;

    @NotNull
    @Schema(example = "99.90")
    private double price;

    public Product() {}

    public Product(ProductDto dto) {
        this.name = dto.name();
        this.price = dto.price();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
