package com.axonactive.companyspringrun2.controllers;

import com.axonactive.companyspringrun2.Entities.Department;
import com.axonactive.companyspringrun2.exception.NotFoundException;
import com.axonactive.companyspringrun2.exception.UnauthorizedAccessException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

public interface DepartmentController {
     List<Department> getAllDepartment();
     Department newDepartment(@RequestHeader("Authentication")String authentication, @RequestBody Department department) throws UnauthorizedAccessException;
     Department getDepartmentById(@PathVariable Integer id) throws NotFoundException;

     Department updateDepartment(@RequestBody Department newDepartment, @PathVariable Integer id) throws NotFoundException;
     void deleteDepartment(@PathVariable Integer id);

}
