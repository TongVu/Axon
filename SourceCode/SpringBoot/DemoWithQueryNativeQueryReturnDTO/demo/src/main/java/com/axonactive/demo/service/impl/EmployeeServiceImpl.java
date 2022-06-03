package com.axonactive.demo.service.impl;

import com.axonactive.demo.entity.Employee;
import com.axonactive.demo.repository.EmployeeRepository;
import com.axonactive.demo.service.EmployeeService;
import com.axonactive.demo.service.dto.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDto> getEmployeeInDepartment(Integer deptid) {
        return employeeRepository.getEmployeeInADepartment(deptid);
    }

    @Override
    public List<Employee> getEmployeeByFirstName(String firstName) {
        return employeeRepository.getEmployeebyFirstname(firstName);
    }
}
