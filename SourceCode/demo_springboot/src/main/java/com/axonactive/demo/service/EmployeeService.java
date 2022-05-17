package com.axonactive.demo.service;

import com.axonactive.demo.entity.Department;
import com.axonactive.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();
}
