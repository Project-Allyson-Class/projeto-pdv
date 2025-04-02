package com.pdv.demo.application.authorization.dtos;

import com.pdv.demo.core.authorization.entities.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterDTO(@NotBlank(message = "Mandatory field")
                          String username,
                          @NotBlank(message = "Mandatory field")
                          String password,
                          @NotNull(message = "Mandatory field")
                          UserRole role) {
}
