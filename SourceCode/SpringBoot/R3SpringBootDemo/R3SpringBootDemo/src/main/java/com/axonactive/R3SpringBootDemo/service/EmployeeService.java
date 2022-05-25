package com.axonactive.R3SpringBootDemo.service;


import com.axonactive.R3SpringBootDemo.entity.Employee;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface EmployeeService {
    List<Employee> getAllEmployee();

    Employee saveEmployee(Employee employee);

    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);

    List<Employee> findEmployeeByFirstNameLike(String firstName);
    List<Employee> findEmployeeByFirstNameLikeAndLastNameLike(String firstName, String lastName);
    List<Employee> findEmployeeByFirstNameIgnoreCaseLike(String firstName);
    List<Employee> findEmployeeByDateOfBirthBefore(int year, int month, int day);
    List<Employee> findEmployeeByAgeLessThan(Integer age);
    List<Employee> findEmployeeByDateOfBirthBetween(LocalDate dateStart, LocalDate dateEnd);
    List<Employee> findEmployeeByDepartmentId(Long id);
    List<Employee> findEmployeeByFirstNameContaining(String pattern);
}
