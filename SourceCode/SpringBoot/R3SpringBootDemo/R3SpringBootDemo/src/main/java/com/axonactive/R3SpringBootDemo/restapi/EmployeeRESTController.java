package com.axonactive.R3SpringBootDemo.restapi;

import com.axonactive.R3SpringBootDemo.entity.Employee;
import com.axonactive.R3SpringBootDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(EmployeeRESTController.PATH)
public class EmployeeRESTController {
    public static final String PATH = "employees";

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long id,
                                                    @RequestBody Employee employee) throws ResourceNotFoundException {
    Employee emp = employeeService.findEmployeeById(id).
            orElseThrow(()->new ResourceNotFoundException("Employee not found " + id));
    emp.setAge(employee.getAge());
    emp.setDateOfBirth(employee.getDateOfBirth());
    emp.setGender(employee.getGender());
    emp.setLastName(employee.getLastName());
    emp.setMiddleName(employee.getMiddleName());
    emp.setFirstName(employee.getFirstName());
    emp.setDepartment(employee.getDepartment());
    emp.setSalary(employee.getSalary());

    return ResponseEntity.ok().body(employeeService.saveEmployee(emp));
    }

}
