package com.axonactive.R3SpringBootDemo.restapi;

import com.axonactive.R3SpringBootDemo.entity.Department;
import com.axonactive.R3SpringBootDemo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(DepartmentLocationRESTController.PATH)
public class DepartmentRESTController {
    public final String PATH = "departments";

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/list")
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartment();
    }

    @GetMapping("/{id}")
    public Optional<Department> getDepartmentById(@PathVariable(value = "id") Long id){
        return departmentService.findDepartmentById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartmentById(@PathVariable(value = "id") Long id,
                                             @RequestBody Department department){
        Department departmentToUpdate = departmentService.findDepartmentById(id).
                orElseThrow(() -> new ResourceNotFoundException("Department not found " + id));
        departmentToUpdate.setDepartmentName(department.getDepartmentName());
        departmentToUpdate.setStartDate(department.getStartDate());

        return ResponseEntity.ok().body(departmentService.saveDepartment(departmentToUpdate));
    }
}
