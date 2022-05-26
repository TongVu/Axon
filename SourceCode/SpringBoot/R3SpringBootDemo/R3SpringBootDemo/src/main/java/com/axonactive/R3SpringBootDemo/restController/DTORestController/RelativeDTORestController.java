package com.axonactive.R3SpringBootDemo.restController.DTORestController;

import com.axonactive.R3SpringBootDemo.dtoData.RelativeDTO;
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
@RequestMapping(RelativeDTORestController.PATH)
public class RelativeDTORestController {
    public static final String PATH = "/relativedtos";

    @Autowired
    RelativeService relativeService;

    @GetMapping("/")
    public List<RelativeDTO> getAllRelativeDTO() {
        return relativeService.toRelativeDTO(relativeService.getAllRelative());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RelativeDTO> getRelativeDTOById(@PathVariable(value = "id")Long id)throws ResourceNotFoundException {
        Relative relative = relativeService.findRelativeById(id).
                orElseThrow(() -> new ResourceNotFoundException("Relative not found " + id));
        RelativeDTO relativeDTO = relativeService.toRelativeDTO(relative);

        return ResponseEntity.ok().body(relativeDTO);
    }

    @GetMapping("/query")
    public ResponseEntity<RelativeDTO> findRelativeDtoByFullName(@RequestParam String name) {
        Optional<Relative> relative = relativeService.findRelativeByFullName(name);
        return ResponseEntity.ok().body(relativeService.toRelativeDTO(relative.get()));
    }

    @PostMapping("/query")
    public ResponseEntity<RelativeDTO> findRelativeDtoByFullNamePost(@RequestParam String name) {
        Optional<Relative> relative = relativeService.findRelativeByFullName(name);
        return ResponseEntity.ok().body(relativeService.toRelativeDTO(relative.get()));
    }

    @PostMapping("/add")
    public Relative create(@RequestBody RelativeDTO relativeDTO) {
        return relativeService.saveRelative(relativeService.toRelativeEntity(relativeDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RelativeDTO> update(@PathVariable(value = "id") Long relativesId,
                                              @RequestBody RelativeDTO relativesDetails) throws ResourceNotFoundException {
        Relative relative = relativeService.findRelativeById(relativesId)
                .orElseThrow(() -> new ResourceNotFoundException("Relatives not found: " + relativesId));
        relative.setFullName(relativesDetails.getFullName());
        relative.setRelationship(relativesDetails.getRelationship());
        relative.setGender(relativesDetails.getGender());
        relative.setEmployee(relativesDetails.getEmployee());
        relative.setPhoneNumber(relativesDetails.getPhoneNumber());
        relativeService.saveRelative(relative);
        Relative updatedRelative = relativeService.saveRelative(relative);
        return ResponseEntity.ok(relativeService.toRelativeDTO(updatedRelative));
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long relativeId) throws Exception {

        Relative relative = relativeService.findRelativeById(relativeId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + relativeId));
        relativeService.deleteRelativeById(relativeId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
