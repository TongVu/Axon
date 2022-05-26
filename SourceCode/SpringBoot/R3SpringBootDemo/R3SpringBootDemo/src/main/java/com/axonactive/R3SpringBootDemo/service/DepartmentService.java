package com.axonactive.R3SpringBootDemo.service;

import com.axonactive.R3SpringBootDemo.dtoData.DepartmentDTO;
import com.axonactive.R3SpringBootDemo.entity.Department;

import java.util.List;
import java.util.Optional;


public interface DepartmentService {
    List<Department> getAllDepartment();

    Department saveDepartment(Department department);

    void deleteDepartmentById(Long id);

    Optional<Department> findDepartmentById(Long id);

    Department toDepartmentEntity(DepartmentDTO departmentDTO);
    List<Department> toDepartmentEntity(List<DepartmentDTO> departmentDTOs);

    DepartmentDTO toDepartmentDTO(Department department);
    List<DepartmentDTO> toDepartmentDTO(List<Department> department);

}
