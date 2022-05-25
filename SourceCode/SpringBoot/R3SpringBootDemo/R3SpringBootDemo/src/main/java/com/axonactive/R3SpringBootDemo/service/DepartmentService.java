package com.axonactive.R3SpringBootDemo.service;

import com.axonactive.R3SpringBootDemo.entity.Department;

import java.util.List;
import java.util.Optional;


public interface DepartmentService {
    List<Department> getAllDepartment();

    Department saveDepartment(Department department);

    void deleteDepartmentById(Long id);

    Optional<Department> findDepartmentById(Long id);

}
