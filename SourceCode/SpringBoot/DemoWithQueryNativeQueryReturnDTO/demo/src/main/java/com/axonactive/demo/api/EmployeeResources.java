package com.axonactive.demo.api;

import com.axonactive.demo.entity.Employee;
import com.axonactive.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeResources {
    private final EmployeeService employeeService;

    @GetMapping
    List<Employee> getEmployeeByFirstName(@RequestParam("firstName") String firstName){
        return employeeService.getEmployeeByFirstName(firstName);
    }
}
