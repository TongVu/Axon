package com.axonactive.demo.api;

import com.axonactive.demo.entity.Assignment;
import com.axonactive.demo.entity.Employee;
import com.axonactive.demo.service.AssignmentService;
import com.axonactive.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeResources {
    private final EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getAllEmployee(){
        List<Employee> allEmployee = employeeService.getAll();
        return allEmployee;
    }
}
