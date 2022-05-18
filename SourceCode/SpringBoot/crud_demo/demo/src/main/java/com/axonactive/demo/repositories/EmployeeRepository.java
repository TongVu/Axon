package com.axonactive.demo.repositories;

import com.axonactive.demo.entities.DepartmentLocation;
import com.axonactive.demo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {
}
