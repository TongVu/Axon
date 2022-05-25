package com.axonactive.R3SpringBootDemo.restapi;

import com.axonactive.R3SpringBootDemo.entity.Employee;
import com.axonactive.R3SpringBootDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(EmployeeRESTController.PATH)
public class EmployeeRESTController {
    public static final String PATH = "employees";

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long id,
                                                    @RequestBody Employee employee) throws ResourceNotFoundException {
        Employee emp = employeeService.findEmployeeById(id).
                orElseThrow(() -> new ResourceNotFoundException("Employee not found " + id));
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

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable(value = "id") Long id,
                                                       @RequestBody Employee employee) throws ResourceNotFoundException {
        Employee empToUpdate = employeeService.findEmployeeById(id).
                orElseThrow(() -> new ResourceNotFoundException("Employee not found " + id));
        empToUpdate.setDepartment(employee.getDepartment());
        empToUpdate.setGender(employee.getGender());
        empToUpdate.setDateOfBirth(employee.getDateOfBirth());
        empToUpdate.setSalary(employee.getSalary());
        empToUpdate.setLastName(employee.getLastName());
        empToUpdate.setFirstName(employee.getFirstName());
        empToUpdate.setMiddleName(employee.getMiddleName());

        return ResponseEntity.ok().body(employeeService.saveEmployee(empToUpdate));
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee emp) {
       return employeeService.saveEmployee(emp);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteEmployeeById(@PathVariable(value = "id") Long id,
                                                       @RequestBody Employee employee)throws ResourceNotFoundException{
        Employee employeeToUpdate = employeeService.findEmployeeById(id).
                orElseThrow(() -> new ResourceNotFoundException("Employee not found " + id));

        employeeService.deleteEmployeeById(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);

        return response;
    }

}
