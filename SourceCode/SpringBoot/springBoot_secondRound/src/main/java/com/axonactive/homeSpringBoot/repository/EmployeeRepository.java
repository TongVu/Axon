package com.axonactive.homeSpringBoot.repository;

import com.axonactive.homeSpringBoot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findBySalaryLessThan(Integer salary);
    List<Employee> findEmployeeByNameLike(String name);
}
