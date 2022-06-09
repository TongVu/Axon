package com.axonactive.service;

import com.axonactive.demo.entity.Department;
import com.axonactive.demo.entity.Employee;
import com.axonactive.service.dto.EmployeeAndTheirKinDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAll();

    Optional<Employee> getEmployeeById(Integer id);

    void saveEmployee(Employee employee);

    void deleteEmployee(Integer id);

    List<Employee> findByLastName(String lastName);

    List<Employee> findByLastNameOrByFirstName(String lastName, String firstName);

    List<Employee> findByFirstName(String firstName);

    List<Employee> findByMiddleName(String middleName);

    List<Employee> findBySalaryLessThan(Integer salary);

    List<Employee> findBySalaryGreaterThan(Integer salary);

    List<Employee> findBySalary(Integer salary);

    List<Employee> findByDepartmentDepartmentName(String departmentName);

    List<Employee> findByDepartmentDepartmentNameLike(String departmentName);

    List<Employee> findByEmployeeLastNameLike(String lastName);

    List<Employee> findBySalaryBetween(Integer minSalary, Integer maxSalary);

    List<Employee> findByLastNameIgnoreCase(String lastname);

    List<Employee> findAllEmployeeInADepartment(Department department);


    List<Employee> findAllOrderByIdAsc();

    List<Employee> findAllOrderByDepartment();

    List<Employee> findAllOrderByLastName();

    List<Employee> employeeWithSameBirthMonth(int month);

    List<EmployeeAndTheirKinDto> findEmployeeAndTheirRelative();
}
