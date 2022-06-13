package com.axonactive.demo.repository;

import com.axonactive.demo.entity.Department;
import com.axonactive.demo.service.DepartmentService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
