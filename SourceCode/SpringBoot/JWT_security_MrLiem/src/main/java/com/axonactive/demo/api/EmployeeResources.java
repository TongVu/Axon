package com.axonactive.demo.api;

import com.axonactive.demo.entity.Employee;
import com.axonactive.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeResources {
    private final EmployeeService employeeService;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    List<Employee> getEmployeeByFirstName(@RequestParam("firstName") String firstName){
        log.info("find employee by firstname {} ", firstName);
        return employeeService.getEmployeeByFirstName(firstName);
    }


}
