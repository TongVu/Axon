package com.axonactive.controller;


import com.axonactive.demo.entity.Employee;
import com.axonactive.exceptions.ResourceNotFound;
import com.axonactive.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/employee")
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/get/id")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Integer id)
            throws ResourceNotFound {
        Employee employee = employeeService.getEmployeeById(id).
                orElseThrow(() -> new ResourceNotFound("Employee not found" + id));
        return ResponseEntity.ok().body(employee);

    }

    @PostMapping("/add")
    public void create(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
    }

    @DeleteMapping
    public Map<String, Boolean> delete(@PathVariable(value = "id") Integer Id) throws Exception {
        Employee employee = employeeService.getEmployeeById(Id)
                .orElseThrow(() -> new ResourceNotFound("Employee not found: " + Id));
        employeeService.deleteEmployee(Id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}