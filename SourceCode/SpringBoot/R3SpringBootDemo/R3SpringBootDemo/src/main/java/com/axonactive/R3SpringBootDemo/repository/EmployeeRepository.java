package com.axonactive.R3SpringBootDemo.repository;

import com.axonactive.R3SpringBootDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {
    List<Employee> findEmployeeByFirstNameLike(String firstName);
    List<Employee> findEmployeeByFirstNameLikeAndLastNameLike(String firstName, String lastName);
    List<Employee> findEmployeeByFirstNameIgnoreCaseLike(String firstName);
    List<Employee> findEmployeeByDateOfBirthBefore(LocalDate parse);
}
