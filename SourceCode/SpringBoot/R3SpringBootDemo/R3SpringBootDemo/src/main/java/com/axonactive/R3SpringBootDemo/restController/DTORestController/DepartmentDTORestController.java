package com.axonactive.R3SpringBootDemo.restController.DTORestController;

import com.axonactive.R3SpringBootDemo.dtoData.DepartmentDTO;
import com.axonactive.R3SpringBootDemo.entity.Department;
import com.axonactive.R3SpringBootDemo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(DepartmentDTORestController.PATH)
public class DepartmentDTORestController {
    public static final String PATH = "departmentdtos";

    @Autowired
    DepartmentService departmentService;

    @GetMapping("")
    public List<DepartmentDTO> getAllDepartmentDTO(){
        return departmentService.toDepartmentDTO(departmentService.getAllDepartment());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentDTOById(
            @PathVariable(value = "id") Long id) throws Exception{
        Department department = departmentService.findDepartmentById(id).
                orElseThrow(() -> new ResourceNotFoundException());

        return ResponseEntity.ok().body(departmentService.toDepartmentDTO(department));
    }

    @PostMapping("/add")
    public Department create(@RequestBody DepartmentDTO departmentDTO) {
        return departmentService.saveDepartment(departmentService.toDepartmentEntity(departmentDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDTO>  update(@PathVariable(value =  "id") Long id,
                                                 @RequestBody DepartmentDTO departmentDTO) throws Exception{
        Department department = departmentService.findDepartmentById(id).
                orElseThrow(() -> new ResourceNotFoundException("Department not found " + id));
        department.setDepartmentName(departmentDTO.getDepartmentName());
        department.setStartDate(departmentDTO.getStartDate());

        departmentService.saveDepartment(department);
        Department updatedDepartment = departmentService.saveDepartment(department);

        return ResponseEntity.ok().body(departmentService.toDepartmentDTO(updatedDepartment));
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long id) throws Exception{
        Department department = departmentService.findDepartmentById(id).
                orElseThrow(() -> new ResourceNotFoundException("Department not found"));
        departmentService.deleteDepartmentById(id);
        Map<String, Boolean > response = new HashMap<>();

        response.put("Deleted", Boolean.TRUE);
        return response;
    }

}
