package com.axonactive.companyspringrun2.controllers;

import com.axonactive.companyspringrun2.Entities.Employee;
import com.axonactive.companyspringrun2.exception.NotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EmployeeController {
    List<Employee> getAllEmployee();
    Employee newEmployee(@RequestBody Employee Employee);
    Employee getEmployeeById(@PathVariable String id) throws NotFoundException;

    Employee updateEmployee(@RequestBody Employee newDepartment, @PathVariable String id) throws NotFoundException;
    void deleteEmployee(@PathVariable String id) throws NotFoundException;
}
