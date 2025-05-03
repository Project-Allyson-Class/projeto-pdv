package com.pdv.demo.application.sales.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record SaleDto(UUID id,
                      @NotNull(message = "Mandatory field")
                      LocalDate saleDate,
                      @NotNull(message = "Mandatory field")
                      double totalAmount,
                      @NotNull(message = "Mandatory field")
                      List<UUID> productIds) {
}
