package com.emp.emp.service;

import com.emp.emp.dto.EmployeeDto;
import com.emp.emp.dto.EmployeeResponseDTo;
import com.emp.emp.entity.Department;
import com.emp.emp.entity.Employee;
import com.emp.emp.repository.DepartmentRepo;
import com.emp.emp.repository.EmployeeRepo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRepo employeeRepo;
    private DepartmentRepo departmentRepo;

    public EmployeeService(EmployeeRepo employeeRepo,DepartmentRepo departmentRepo){
        this.employeeRepo = employeeRepo;
        this.departmentRepo = departmentRepo;
    }


    @Transactional
    public EmployeeDto createEmployee(EmployeeDto employee) {
        try {
            Employee employee1 = new Employee();
            employee1.setName(employee.name());
            employee1.setRole(employee.role());
            employee1.setUsername(employee.username());
            employee1.setEmail(employee.email());
            employee1.setPassword(employee.password());
            Department department = departmentRepo.findById(employee.department()).orElseThrow(() -> new RuntimeException("Invalid department ID"));
            employee1.setDepartment(department);
            Employee save = employeeRepo.save(employee1);
            return new EmployeeDto(save.getName(), save.getRole(), save.getUsername(), save.getEmail(), save.getPassword(), save.getDepartment().getId());
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to create employee: " + e.getMessage());
        }


    }
    @Cacheable(value = "employeesCache", key = "'allEmployees'")
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepo.findAll().stream().map(emp -> new EmployeeDto(
                emp.getName(),
                emp.getRole(),
                emp.getUsername(),
                emp.getEmail(),
                emp.getPassword(),
                emp.getDepartment().getId()
        )).toList();
    }
    @Cacheable(value = "employeesCache", key = "#id")
    public EmployeeDto getEmployeeById(Long id) {
        return employeeRepo.findById(id).map(emp -> new EmployeeDto(
                emp.getName(),
                emp.getRole(),
                emp.getUsername(),
                emp.getEmail(),
                emp.getPassword(),
                emp.getDepartment().getId()
        )).orElse(null);
    }

    public EmployeeDto updateEmployee(Long id, EmployeeDto employee) {
        // Implementation for updating an employee can be added here
        Employee employee1 = employeeRepo.findById(id).orElse(null);
        if(employee1 != null) {
            employee1.setName(employee.name());
            employee1.setRole(employee.role());
            employee1.setUsername(employee.username());
            employee1.setEmail(employee.email());
            employee1.setPassword(employee.password());
            Department department = departmentRepo.findById(employee.department()).orElseThrow();
            employee1.setDepartment(department);
            Employee save = employeeRepo.save(employee1);
            return new EmployeeDto(save.getName(), save.getRole(), save.getUsername(), save.getEmail(), save.getPassword(), save.getDepartment().getId());
        }
        else {
            throw new RuntimeException("Employee not found with id: " + id);
        }
    }

    public boolean deleteEmployee(Long id) {
        Employee employee = employeeRepo.findById(id).orElse(null);
        if(employee != null) {
            employeeRepo.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

    public EmployeeResponseDTo getByUsername(String username){
        Employee employee = employeeRepo.findByUsername(username);
        return new EmployeeResponseDTo(employee.getName(),employee.getEmail(),employee.getUsername(),employee.getRole(),employee.getDepartment().getDeptName());
    }

}
