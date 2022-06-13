package com.axonactive.companyspringrun2.controllers;

import com.axonactive.companyspringrun2.Entities.DepartmentLocation;
import com.axonactive.companyspringrun2.exception.NotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface DepartmentLocationController {
    List<DepartmentLocation> getAllDepartmentLocation();
    DepartmentLocation newDepartmentLocation(@RequestBody DepartmentLocation departmentLocation);
    DepartmentLocation getDepartmentById(@PathVariable Integer id) throws NotFoundException;

    DepartmentLocation updateDepartment(@RequestBody DepartmentLocation newDepartment, @PathVariable Integer id) throws NotFoundException;
    void deleteDepartmentLocation(@PathVariable Integer id) throws NotFoundException;
}
