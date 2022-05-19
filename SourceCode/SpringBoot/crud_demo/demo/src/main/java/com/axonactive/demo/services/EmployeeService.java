package com.axonactive.demo.services;

import com.axonactive.demo.entities.Department;
import com.axonactive.demo.entities.Employee;

import java.util.List;
import java.util.Optional;


public interface EmployeeService {
    List<Employee> getAllEmployee();

    void saveEmployee(Employee employee);

    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);

}
