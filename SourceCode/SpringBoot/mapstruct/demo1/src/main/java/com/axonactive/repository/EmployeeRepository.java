package com.axonactive.repository;

import com.axonactive.demo.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByLastName(String lastName);

    List<Employee> findEmployeeByLastNameOrFirstName(String lastName, String firstName);

    List<Employee> findByLastNameLike(String lastName);

    List<Employee> findEmployeeByMiddleName(String middleName);

    List<Employee> findBySalaryLessThan(Integer salary);

    List<Employee> findBySalaryGreaterThan(Integer salary);

    List<Employee> findBySalary(Integer salary);

    List<Employee> findBySalaryBetween(Integer minSalary, Integer maxSalary);

    List<Employee> findByLastNameIgnoreCase(String lastname);

    List<Employee> findByDepartmentDepartmentName(String departmentName);

    List<Employee> findByDepartmentDepartmentNameLike(String departmentName);

    List<Employee> findByFirstName(String firstName);

    List<Employee>  findAllByOrderById();

    List<Employee> findAllByOrderByDepartment();

    List<Employee> findAllByOrderByLastName();


}

