package com.axonactive.R3SpringBootDemo.restapi;

import ch.qos.logback.core.recovery.ResilientOutputStreamBase;
import com.axonactive.R3SpringBootDemo.entity.Relative;
import com.axonactive.R3SpringBootDemo.service.RelativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(RelativesRESTController.PATH)
public class RelativesRESTController {
    public static final String PATH = "/relatives";

    @Autowired
    RelativeService relativeService;

    @GetMapping("")
    public List<Relative> getAllRelatives(){
        return relativeService.getAllRelative();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Relative> getRelativeById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Relative relative = relativeService.findRelativeById(id).
                orElseThrow(() -> new ResourceNotFoundException("Relative not found " + id));

        return ResponseEntity.ok().body(relative);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Relative> updateRelative(@PathVariable(value = "id") Long id,
                                                   @RequestBody Relative relative) throws ResourceNotFoundException{
        Relative relativeToUpdate = relativeService.findRelativeById(id).
                    orElseThrow(() -> new ResourceNotFoundException("Relative not found " + id));

        relativeToUpdate.setEmployee(relative.getEmployee());
        relativeToUpdate.setGender(relative.getGender());
        relativeToUpdate.setRelationship(relative.getRelationship());
        relativeToUpdate.setFullName(relative.getFullName());
        relativeToUpdate.setPhoneNumber(relative.getPhoneNumber());

        return relativeService.saveRelative(relativeToUpdate);
    }

    @PostMapping("/add")
    public ResponseEntity<Relative> addRelative(@RequestBody Relative relative){
        return relativeService.saveRelative(relative);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteRelativeById(@PathVariable(value = "id") Long id,
                                                   @RequestBody Relative relative) throws ResourceNotFoundException{
        Relative relativeToDelete = relativeService.findRelativeById(id).
                orElseThrow(() -> new ResourceNotFoundException("Relative not found " + id));
        relativeService.deleteRelativeById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);

        return response;
    }


}
