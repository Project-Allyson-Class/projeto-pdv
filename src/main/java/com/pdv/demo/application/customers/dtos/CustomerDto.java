package com.pdv.demo.application.customers.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CustomerDto(UUID id,
                          @NotBlank(message = "Mandatory field")
                          String name,
                          @Email(message = "Invalid email format")
                          @NotBlank(message = "Mandatory field")
                          String email,
                          @NotNull(message = "Mandatory field")
                          String phoneNumber) {
}
