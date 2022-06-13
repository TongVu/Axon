package com.axonactive.companyspringrun2.controllers.implement;

import com.axonactive.companyspringrun2.Entities.Relatives;
import com.axonactive.companyspringrun2.Service.RelativesService;
import com.axonactive.companyspringrun2.controllers.RelativesController;
import com.axonactive.companyspringrun2.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/relatives")
public class RelativesControllerImpl implements RelativesController {

    private final RelativesService relativesService;

    @Override
    @GetMapping("/list")
    public List<Relatives> getAllRelatives() {
        return relativesService.getAllRelatives();
    }

    @Override
    @PostMapping("/create")
    public Relatives newRelatives(@RequestBody Relatives relatives) {
        return relativesService.saveRelative(relatives);
    }

    @Override
    @GetMapping("/{id}")
    public Relatives getRelativesById(@PathVariable Integer id) throws NotFoundException {
        return relativesService.findRelative(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    @PutMapping("update/{id}")
    public Relatives updateRelatives(@RequestBody Relatives newRelatives,@PathVariable Integer id) throws NotFoundException {
        return relativesService.findRelative(id)
                .map(relatives -> {
                    relatives.setFullName(newRelatives.getFullName());
                    relatives.setGender(newRelatives.getGender());
                    relatives.setRelationship(newRelatives.getRelationship());
                    relatives.setPhoneNumber(newRelatives.getPhoneNumber());
                    return  relativesService.saveRelative(relatives);
                }).orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteDepartment(@PathVariable Integer id) throws NotFoundException {
        for (Relatives relatives: relativesService.getAllRelatives()){
            if ( relatives.getId().compareTo(id) == 0 ){
                relativesService.deleteRelative(id);
                System.out.println("Delete success!");
            }else throw new NotFoundException(id);
        }
    }
}
