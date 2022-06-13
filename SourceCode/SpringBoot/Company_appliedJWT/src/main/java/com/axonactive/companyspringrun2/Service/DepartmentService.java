package com.axonactive.companyspringrun2.Service;

import com.axonactive.companyspringrun2.Entities.Department;
import com.axonactive.companyspringrun2.Service.implement.DepartmentNameAndNumberOfEmployeesDto;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    List<Department> getAllDepartment();

    Department saveDepartment(Department department);

    void deleteDepartment(Integer id);

    Optional<Department> findDepartment(Integer id);

    List<DepartmentNameAndNumberOfEmployeesDto> departmentNameAndNumberOfEmployees();
}
