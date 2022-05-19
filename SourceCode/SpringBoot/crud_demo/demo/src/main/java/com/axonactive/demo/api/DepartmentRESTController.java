package com.axonactive.demo.ffsfsadfsafe;

import com.axonactive.demo.entities.Department;
import com.axonactive.demo.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/department")

public class DepartmentRESTController {

    private final DepartmentService departmentService;

    @GetMapping("/list")
    public List<Department> getAll(){
        return departmentService.getAllDepartment();
    }

    @GetMapping("/get/{id}")
    public Optional<Department> getDepartmentById(long id){
        return departmentService.findDepartmentById(id);
    }

    @PostMapping("/add")
    public Department create(@RequestBody Department department) {
        departmentService.saveDepartment(department);

        return department;
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") long id) throws Exception {
       Department department = departmentService.findDepartmentById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + id));
        departmentService.deleteDepartmentById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
