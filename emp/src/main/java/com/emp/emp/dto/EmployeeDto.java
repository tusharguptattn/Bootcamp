package com.emp.emp.dto;

import com.emp.emp.entity.Department;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EmployeeDto(

        @NotBlank(message = "Name is mandatory")
        String name,
        @Email(message = "Email should be valid")
        String email,
        String username,
        String role,
        @Size(min = 8, message = "Password must be at least 8 characters long")
        String password,
        Long department
) {
}
