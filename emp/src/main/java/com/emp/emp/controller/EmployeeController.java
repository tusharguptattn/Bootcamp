package com.emp.emp.controller;

import com.emp.emp.dto.EmployeeDto;
import com.emp.emp.dto.EmployeeResponseDTo;
import com.emp.emp.service.EmployeeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;


    // Constructor Injection
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto employee) {
        return ResponseEntity.ok(employeeService.createEmployee(employee));

    }
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        if(employees.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable @Min(1) Long id) {
        EmployeeDto employee = employeeService.getEmployeeById(id);
        if(employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }


    @PutMapping
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDto employee) {
        // Implementation for updating an employee can be added here

        EmployeeDto employee1 = employeeService.updateEmployee(id, employee);
        if(employee1 != null) {
            return ResponseEntity.ok(employee1);
        }
        else {
            return ResponseEntity.notFound().build();
        }


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        // Implementation for deleting an employee can be added here
        boolean s = employeeService.deleteEmployee(id);
        if(s) {
            return ResponseEntity.ok("Employee deleted successfully");
        }
        else {
            return ResponseEntity.badRequest().body("Employee not found with id: " + id);
        }
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<EmployeeResponseDTo> getByUsername(@PathVariable("username") String userName){
        return ResponseEntity.ok(employeeService.getByUsername(userName));
    }






}
