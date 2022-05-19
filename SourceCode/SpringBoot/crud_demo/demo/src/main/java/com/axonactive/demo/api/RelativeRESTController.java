package com.axonactive.demo.restcontrollers;

import com.axonactive.demo.entities.Relative;
import com.axonactive.demo.services.RelativeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/relative")

public class RelativeRESTController {

    private final RelativeService relativeService;

    @GetMapping("/list")
    public List<Relative> getAll(){
        return relativeService.getAllRelative();
    }

    @GetMapping("/get/{id}")
    public Optional<Relative> getRelativeById(long id){
        return relativeService.findRelativeById(id);
    }

    @PostMapping("/add")
    public Relative create(@RequestBody Relative relative) {
        relativeService.saveRelative(relative);

        return relative;
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") long id) throws Exception {
       Relative relative = relativeService.findRelativeById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + id));
        relativeService.deleteRelativeById(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
