package com.emp.emp.controller;

import com.emp.emp.dto.DepartmentDto;
import com.emp.emp.dto.DeptEmployeeRnDTO;
import com.emp.emp.dto.EmployeeDto;
import com.emp.emp.entity.Department;
import com.emp.emp.service.DepartmentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private DepartmentService departmentService;


    private DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@Valid @RequestBody DepartmentDto departmentDto) {
        // Implementation for creating a department can be added here
        return ResponseEntity.ok(departmentService.createDepartment(departmentDto));
    }


    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        List<DepartmentDto> departments = departmentService.getAllDepartments();
        if (departments.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(departments);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(Long id) {
        DepartmentDto department = departmentService.getDepartmentById(id);
        if (department == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(department);
    }
    @PutMapping
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable Long id, @Valid @RequestBody DepartmentDto departmentDto) {
        // Implementation for updating a department can be added here

        DepartmentDto department = departmentService.updateDepartment(id, departmentDto);
        if (department != null) {
            return ResponseEntity.ok(department);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
        // Implementation for deleting a department can be added here
        boolean isDeleted = departmentService.deleteDepartment(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Delete department with id: " + id);
    }

    @GetMapping("/{deptId}/employees")
    public ResponseEntity<List<DeptEmployeeRnDTO>> getAllEmployeeInDept(@PathVariable @Min(1) Long deptId) {
        return ResponseEntity.ok(departmentService.getAllEmployeesByDepartmentId(deptId));
    }

    @PutMapping("/{deptId}/employee/{empId}")
    public ResponseEntity<String>  assignEmployeeToDepartment(@PathVariable Long deptId, @PathVariable Long empId) {
        departmentService.assignEmployeeToDepartment(deptId, empId);
        return ResponseEntity.ok("Updated");
    }
}
