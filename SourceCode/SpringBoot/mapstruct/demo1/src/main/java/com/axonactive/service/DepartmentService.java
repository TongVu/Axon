package com.axonactive.service;

import com.axonactive.demo.entity.Department;
import com.axonactive.demo.entity.DepartmentLocation;
import com.axonactive.service.dto.DepartmentAndTheirPro;
import com.axonactive.service.dto.DepartmentU23Report;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    List<Department> getAll();
    Optional<Department> getDepartmentById(Integer id);
    void saveDepartment(Department department);
    void deleteDepartment(Integer id);

    List<DepartmentU23Report> departmentU23Report();

    List<DepartmentAndTheirPro> departmentAndTheirPro();

    List<DepartmentAndTheirPro> departmentNameAndTheirPro();


    List<DepartmentAndTheirPro> departmentObjectAndTheirPro();


}
