package com.axonactive.demo.service;

import com.axonactive.demo.entity.Employee;
import com.axonactive.demo.service.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getEmployeeInDepartment(Integer deptid);
    List<Employee> getEmployeeByFirstName(String firstName);
}
