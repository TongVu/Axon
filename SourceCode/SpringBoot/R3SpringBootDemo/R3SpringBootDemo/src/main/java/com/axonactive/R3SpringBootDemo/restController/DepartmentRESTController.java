package com.axonactive.R3SpringBootDemo.restController;

import com.axonactive.R3SpringBootDemo.entity.Department;
import com.axonactive.R3SpringBootDemo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(DepartmentRESTController.PATH)
public class DepartmentRESTController {
    public static final String PATH = "api/department";

    @Autowired
    DepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartment() {
        return departmentService.getAllDepartment();
    }

    @GetMapping("/{id}")
    public Optional<Department> getDepartmentById(@PathVariable(value = "id") Long id) {
        return departmentService.findDepartmentById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartmentById(@PathVariable(value = "id") Long id,
                                                           @RequestBody Department department) {
        Department departmentToUpdate = departmentService.findDepartmentById(id).
                orElseThrow(() -> new ResourceNotFoundException("Department not found " + id));
        departmentToUpdate.setDepartmentName(department.getDepartmentName());
        departmentToUpdate.setStartDate(department.getStartDate());

        return ResponseEntity.ok().body(departmentService.saveDepartment(departmentToUpdate));
    }

    @PostMapping("/add")
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteDepartmentById(@PathVariable(value = "id") Long id ) {
        Department department = departmentService.findDepartmentById(id).
                orElseThrow(() -> new ResourceNotFoundException("Department not found " + id));

        departmentService.deleteDepartmentById(id);
        Map<String, Boolean> response = new HashMap<String, Boolean>();
        response.put("Deleted", Boolean.TRUE);

        return response;
    }

}
