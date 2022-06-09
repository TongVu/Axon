package com.axonactive.controller;

import com.axonactive.demo.entity.DepartmentLocation;
import com.axonactive.demo.entity.Employee;
import com.axonactive.demo.entity.Location;
import com.axonactive.demo.entity.Relatives;
import com.axonactive.exceptions.ResourceNotFound;
import com.axonactive.service.RelativeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/employee/relative")
public class RelativeRestController {
    @Autowired
    private RelativeService relativesService;

    @GetMapping("/list")
    public List<Relatives> getAll(){
    return relativesService.getAll();
    }

    @GetMapping("/get/id")
    public ResponseEntity<Relatives> getEmployeeById(@PathVariable(value = "id") Integer id)
    throws ResourceNotFound {
    Relatives relative=relativesService.getRelativeById(id).
            orElseThrow(()->new ResourceNotFound("Relative not found"+id));
    return ResponseEntity.ok().body(relative);
    }

    @PostMapping("/add")
    public void create(@RequestBody Relatives relative){
        relativesService.saveRelative(relative);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Integer Id) throws Exception {
        Relatives relatives = relativesService.getRelativeById(Id)
                .orElseThrow(() -> new ResourceNotFound("Relative not found: " + Id));
        relativesService.deleteRelative(Id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
