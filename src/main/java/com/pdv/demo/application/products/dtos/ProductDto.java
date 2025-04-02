package com.pdv.demo.application.products.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ProductDto(UUID id,
                         @NotBlank(message = "Mandatory field")
                         String name,
                         @NotNull
                         double price) {
}
