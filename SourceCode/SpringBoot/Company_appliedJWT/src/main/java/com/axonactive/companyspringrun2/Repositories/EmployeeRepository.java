package com.axonactive.companyspringrun2.Repositories;

import com.axonactive.companyspringrun2.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,String> {
    Employee findByLastName(String lastname);
    Employee findByFirstName(String firstName);
    Employee findByLastNameOrFirstName(String lastName,String firstName);
    List<Employee> findByDateOfBirthBetween(LocalDate date1,LocalDate date2);

//    List<Employee> findByAgeLessThan(int age);

    List<Employee> findByMiddleNameIsNull();

    List<Employee> findByLastNameIsNotNull();

    Employee findByLastNameIgnoreCase(String lastName);

    Employee findByFirstNameStartingWith (String letter);

    List<Employee> findByDepartmentId (Integer id);

    List<Employee> findByDepartmentDepartmentName (String name);

    List<Employee> findByDepartmentStartDate (LocalDate startDate);

    List<Employee> findByDepartmentDepartmentNameIgnoreCase (String name);

    List<Employee> findByDepartmentDepartmentNameStartingWith (String letter);

    List<Employee> findByDepartmentDepartmentNameIsNotNull();
}
