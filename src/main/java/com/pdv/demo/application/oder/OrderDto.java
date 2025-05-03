package com.pdv.demo.application.oder;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record OrderDto(UUID id,
                       @NotBlank(message = "Mandatory field")
                       String status,
                       @NotNull(message = "Mandatory field")
                       UUID customerId,
                       @NotNull(message = "Mandatory field")
                       double totalAmount) {
}
