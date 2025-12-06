package com.emp.emp.service;

import com.emp.emp.dto.DepartmentDto;
import com.emp.emp.dto.DeptEmployeeRnDTO;
import com.emp.emp.entity.Department;
import com.emp.emp.entity.Employee;
import com.emp.emp.repository.DepartmentRepo;
import com.emp.emp.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepo departmentRepo;
    private final EmployeeRepo employeeRepo;
    public DepartmentService(DepartmentRepo departmentRepo, EmployeeRepo employeeRepo) {
        this.departmentRepo = departmentRepo;
        this.employeeRepo = employeeRepo;
    }

    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        // Implementation for creating a department can be added here

        Department departmentEntity = new Department();
        departmentEntity.setDeptName(departmentDto.name());
        Department save = departmentRepo.save(departmentEntity);
        return new DepartmentDto(save.getDeptName());
    }


    public List<DepartmentDto> getAllDepartments() {
        return departmentRepo.findAll().stream().map(dept-> new DepartmentDto(
                dept.getDeptName()
        )).toList();
    }

    public DepartmentDto getDepartmentById(Long id) {
        return departmentRepo.findById(id).map(dept->new DepartmentDto(dept.getDeptName())).orElse(null);
    }


    public DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto) {
        // Implementation for updating a department can be added here
        Department department = departmentRepo.findById(id).orElse(null);
        if(department != null) {
            department.setDeptName(departmentDto.name());
            Department save = departmentRepo.save(department);
            return new DepartmentDto(save.getDeptName());
        }
        else {
            return null;
        }
    }

    public boolean deleteDepartment(Long id) {
        // Implementation for deleting a department can be added here
        if(departmentRepo.existsById(id)) {
            departmentRepo.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }


    public List<DeptEmployeeRnDTO> getAllEmployeesByDepartmentId(Long departmentId) {
        List<Employee> byDepartmentDeptId = employeeRepo.findByDepartmentId(departmentId);
        System.out.println(byDepartmentDeptId.size());
        return byDepartmentDeptId.stream().map(emp-> new DeptEmployeeRnDTO(
                emp.getName()
        )).toList();
    }


    public void assignEmployeeToDepartment(Long deptId, Long empId) {
        Employee employee = employeeRepo.findById(empId).orElseThrow();
        Department department = departmentRepo.findById(deptId).orElseThrow();
        employee.setDepartment(department);

        department.getEmployeeInDept().add(employee);
        employeeRepo.save(employee);

    }

}
