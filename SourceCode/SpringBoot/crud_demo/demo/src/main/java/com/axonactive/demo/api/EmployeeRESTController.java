package com.axonactive.demo.ffsfsadfsafe;

import com.axonactive.demo.entities.Employee;
import com.axonactive.demo.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")

public class EmployeeRESTController {

    private final EmployeeService employeeService;

    @GetMapping("/list")
    public List<Employee> getAll(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/get/{id}")
    public Optional<Employee> getEmployeeById(long id){
        return employeeService.findEmployeeById(id);
    }

    @PostMapping("/add")
    public Employee create(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);

        return employee;
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteEmployeeById(@PathVariable(value = "id") long id) throws Exception {
       Employee employee = employeeService.findEmployeeById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + id));
        employeeService.deleteEmployeeById(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
