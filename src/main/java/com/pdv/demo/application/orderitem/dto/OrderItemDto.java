package com.pdv.demo.application.orderitem.dto;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record OrderItemDto(UUID id,
                           @NotNull(message = "Mandatory field")
                           UUID productId,
                           @NotNull(message = "Mandatory field")
                           int quantity,
                           @NotNull(message = "Mandatory field")
                           double price) {
}
