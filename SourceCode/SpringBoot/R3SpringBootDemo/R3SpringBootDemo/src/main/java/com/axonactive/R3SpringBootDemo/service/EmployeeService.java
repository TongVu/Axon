package com.axonactive.R3SpringBootDemo.service;


import com.axonactive.R3SpringBootDemo.entity.Employee;

import java.util.List;
import java.util.Optional;


public interface EmployeeService {
    List<Employee> getAllEmployee();

    void saveEmployee(Employee employee);

    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);

    List<Employee> findEmployeeByFirstNameLike(String firstName);
    List<Employee> findEmployeeByFirstNameLikeAndLastNameLike(String firstName, String lastName);
    List<Employee> findEmployeeByFirstNameIgnoreCaseLike(String firstName);
    List<Employee> findEmployeeByDateOfBirthBefore(int year, int month, int day);
}
