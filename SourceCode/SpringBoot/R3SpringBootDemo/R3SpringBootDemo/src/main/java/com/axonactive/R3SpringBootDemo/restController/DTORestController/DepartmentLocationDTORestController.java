package com.axonactive.R3SpringBootDemo.restController.DTORestController;

import com.axonactive.R3SpringBootDemo.dtoData.DepartmentLocationDTO;
import com.axonactive.R3SpringBootDemo.entity.Department;
import com.axonactive.R3SpringBootDemo.entity.DepartmentLocation;
import com.axonactive.R3SpringBootDemo.restController.DepartmentLocationRESTController;
import com.axonactive.R3SpringBootDemo.service.DepartmentLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(DepartmentLocationRESTController.PATH)
public class DepartmentLocationDTORestController {
    public static final String PATH = "/departmentlocation";
    @Autowired
    DepartmentLocationService departmentLocationService;

    @GetMapping("")
    public List<DepartmentLocationDTO> getAllDepartmentLocationDTO() {
        return departmentLocationService.toDepartmentLocationDTO(departmentLocationService.getAllDepartmentLocation());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentLocationDTO> getDepartmentLocationById(@PathVariable(value = "id") Long id) throws Exception {
        DepartmentLocation departmentLocation = departmentLocationService.findDepartmentLocationById(id).
                orElseThrow(() -> new ResourceNotFoundException("Department Location not found " + id));
        return ResponseEntity.ok().body(departmentLocationService.toDepartmentLocationDTO(departmentLocation));
    }

    @PostMapping("/add")
    public DepartmentLocation add(@RequestBody DepartmentLocationDTO departmentLocationDTO) {
        return departmentLocationService.saveDepartmentLocation(
                departmentLocationService.
                        toDepartmentLocationEntity(departmentLocationDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentLocationDTO> update(@PathVariable(value = "id") Long id,
                                                        @RequestBody DepartmentLocationDTO departmentLocationDTO){
        DepartmentLocation departmentLocation = departmentLocationService.findDepartmentLocationById(id).
                orElseThrow(() -> new ResourceNotFoundException("DepartmentLocation not found " + id));
        departmentLocation.setLocation(departmentLocationDTO.getLocation());
        departmentLocation.setDepartment(departmentLocationDTO.getDepartment());
        DepartmentLocation updatedDepartmentLocation = departmentLocationService.saveDepartmentLocation(departmentLocation);

        return ResponseEntity.ok().body(departmentLocationService.toDepartmentLocationDTO(updatedDepartmentLocation));
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id")Long id) throws Exception{
        DepartmentLocation departmentLocation = departmentLocationService.findDepartmentLocationById(id).
                orElseThrow(() -> new ResourceNotFoundException("DepartmentLocation not found " + id));
        departmentLocationService.deleteDepartmentLocation(id);

        Map<String, Boolean>  response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }



}
