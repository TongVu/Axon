package com.axonactive.R3SpringBootDemo.restController.DTORestController;

import com.axonactive.R3SpringBootDemo.dtoData.EmployeeDTO;
import com.axonactive.R3SpringBootDemo.dtoData.ProjectDTO;
import com.axonactive.R3SpringBootDemo.entity.Employee;
import com.axonactive.R3SpringBootDemo.entity.Project;
import com.axonactive.R3SpringBootDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(EmployeeDTORestController.PATH)
public class EmployeeDTORestController {
    public static final String PATH = "/employeeDTOs";

    @Autowired
    EmployeeService employeeService;


    @GetMapping("")
    public List<EmployeeDTO> getAllEmployeeDTO(){
        return employeeService.toEmployeeDTO(employeeService.getAllEmployee());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeDTOById(@PathVariable(value = "id") Long id) throws Exception{
        Employee employee = employeeService.findEmployeeById(id).
                orElseThrow(() -> new ResourceNotFoundException("Employee not found " + id));
        return ResponseEntity.ok().body(employeeService.toEmployeeDTO(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> update(@PathVariable(value = "id")Long id,
                                             @RequestBody EmployeeDTO employeeDTO){
        Employee employee = employeeService.findEmployeeById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found" + id));
        employee.setEmployeeid(employeeDTO.getEmployeeid());
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setGender(employeeDTO.getGender());
        employee.setSalary(employeeDTO.getSalary());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setMiddleName(employeeDTO.getMiddleName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());

        Employee updatedEmployee = employeeService.saveEmployee(employee);

        return ResponseEntity.ok().body(employeeService.toEmployeeDTO(updatedEmployee));
    }

    @PostMapping("/add")
    public Employee add(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.saveEmployee(employeeService.toEmployeeEntity(employeeDTO));
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id")Long id) {
        Employee employee = employeeService.findEmployeeById(id).
                orElseThrow(() -> new ResourceNotFoundException("Employee not found " + id));
        employeeService.deleteEmployeeById(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }
}
