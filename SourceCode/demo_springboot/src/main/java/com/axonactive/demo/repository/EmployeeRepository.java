package com.axonactive.demo.repository;

import com.axonactive.demo.entity.DepartmentLocation;
import com.axonactive.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
