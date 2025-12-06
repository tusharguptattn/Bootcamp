package com.emp.emp.dto;

import com.emp.emp.entity.Department;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EmployeeResponseDTo(@NotBlank(message = "Name is mandatory")
                                  String name,
                                  @Email(message = "Email should be valid")
                                  String email,
                                  String username,
                                  String role,
                                  String department) {
}
