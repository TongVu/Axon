package com.axonactive.demo.service.impl;

import com.axonactive.demo.entity.Employee;
import com.axonactive.demo.repository.EmployeeRepository;
import com.axonactive.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll(){
        return  employeeRepository.findAll();
    }
}
