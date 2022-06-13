package com.axonactive.companyspringrun2.controllers;

import com.axonactive.companyspringrun2.Entities.Relatives;
import com.axonactive.companyspringrun2.exception.NotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface RelativesController {

    List<Relatives> getAllRelatives();
    Relatives newRelatives(@RequestBody Relatives Relatives);
    Relatives getRelativesById(@PathVariable Integer id) throws NotFoundException;

    Relatives updateRelatives(@RequestBody Relatives newDepartment, @PathVariable Integer id) throws NotFoundException;
    void deleteDepartment(@PathVariable Integer id) throws NotFoundException;



}
