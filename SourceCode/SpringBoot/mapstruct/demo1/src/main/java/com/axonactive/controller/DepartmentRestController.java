package com.axonactive.controller;

import com.axonactive.demo.entity.Department;
import com.axonactive.demo.entity.DepartmentLocation;
import com.axonactive.exceptions.ResourceNotFound;
import com.axonactive.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/department")
public class DepartmentRestController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/list")
    public List<Department> getALL() {
        return departmentService.getAll();
    }

    @GetMapping("/get/id")
    public ResponseEntity<Department> getDepartmentById(@PathVariable(value = "id") Integer id)
            throws ResourceNotFound {
        Department department = departmentService.getDepartmentById(id).
                orElseThrow(() -> new ResourceNotFound("Department not found" + id));
        return ResponseEntity.ok().body(department);
    }

    @PostMapping("/add")
    public void create(@RequestBody Department department) {
        departmentService.saveDepartment(department);
    }

    @DeleteMapping
    public Map<String, Boolean> delete(@PathVariable(value = "id") Integer Id) throws Exception {
        Department department = departmentService.getDepartmentById(Id)
                .orElseThrow(() -> new ResourceNotFound("Department  not found: " + Id));
        departmentService.deleteDepartment(Id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}