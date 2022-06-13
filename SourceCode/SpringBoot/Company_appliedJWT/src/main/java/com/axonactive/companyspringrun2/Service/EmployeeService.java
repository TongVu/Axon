package com.axonactive.companyspringrun2.Service;

import com.axonactive.companyspringrun2.Entities.Employee;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    Employee saveEmployee(Employee employee);

    void deleteEmployee(String id);

    Optional<Employee> findEmployee(String id);

    Employee findByLastname(String lastname);

   Employee findByFirstName(String firstName);

    Employee findByLastNameOrFirstName(String lastName, String firstName);

    List<Employee> findByDateOfBirthBetween(LocalDate date1, LocalDate date2);

    List<Employee> findByMiddleNameIsNull();

//    List<Employee> findByAgeLessThan (int age);
    List<Employee> findByLastNameIsNotNull();

    Employee findByLastNameIgnoreCase(String lastName);

    Employee findByFirstNameStaringWith(String letter);

    List<Employee> findByDepartmentId (Integer id);

    List<Employee> findByDepartmentDepartmentName (String name);

    List<Employee> findByDepartmentStartDate (int year,int month,int day);

    List<Employee> findByDepartmentDepartmentNameIgnoreCase (String name);

    List<Employee> findByDepartmentDepartmentNameStartingWith (String letter);

    List<Employee> findByDepartmentDepartmentNameIsNotNull();

    List<Employee> findEmployeeByBirthMonth(int month);

    List<EmployeeAndRelativeDto> findAllEmployeeAndTheirRelative();
}