package com.emp.emp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DepartmentDto(
        @NotNull
        @NotBlank
        String name
) {
}
