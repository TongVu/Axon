package com.axonactive.demo.services;

import com.axonactive.demo.entities.Department;
import com.axonactive.demo.entities.DepartmentLocation;

import java.util.List;
import java.util.Optional;


public interface DepartmentService {
    List<Department> getAllDepartment();

    void saveDepartment(Department department);

    void deleteDepartmentById(Long id);

    Optional<Department> findDepartmentById(Long id);

}
