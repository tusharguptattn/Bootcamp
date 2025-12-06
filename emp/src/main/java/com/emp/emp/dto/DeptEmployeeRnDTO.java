package com.emp.emp.dto;

import com.emp.emp.entity.Employee;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DeptEmployeeRnDTO(@NotNull
                                @NotBlank
                                String name) {
}
