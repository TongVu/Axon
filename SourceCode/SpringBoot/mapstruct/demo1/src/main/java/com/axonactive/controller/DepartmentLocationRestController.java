package com.axonactive.controller;

import com.axonactive.demo.entity.DepartmentLocation;
import com.axonactive.demo.entity.Location;
import com.axonactive.exceptions.ResourceNotFound;
import com.axonactive.repository.DepartmentLocationRepository;
import com.axonactive.service.DepartmentLocationService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/api/departmentlocation")
public class DepartmentLocationRestController {
    @Autowired
    private DepartmentLocationService departmentLocationService;

    @Autowired
    private DepartmentLocationRepository departmentLocationRepository;

    @GetMapping("/list")
    public List<DepartmentLocation> getAll() {
        return departmentLocationService.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<DepartmentLocation> getDepartmentLocationByID(@PathVariable(value = "id") Integer id)
            throws ResourceNotFound {
        DepartmentLocation departmentLocation = departmentLocationService.getDepartmentLocationById(id).
                orElseThrow(() -> new ResourceNotFound("User not found" + id));
        return ResponseEntity.ok().body(departmentLocation);
    }

    @PostMapping("/add")
    public void create(@RequestBody DepartmentLocation departmentLocation) {
        departmentLocationService.saveDepartmentLocation(departmentLocation);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Integer Id) throws Exception {
        DepartmentLocation departmentLocation = departmentLocationService.getDepartmentLocationById(Id)
                .orElseThrow(() -> new ResourceNotFound("Department Location not found: " + Id));
        departmentLocationService.deleteDepartmentLocation(Id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
