package com.axonactive.service;

import com.axonactive.demo.entity.DepartmentLocation;
import com.axonactive.demo.entity.Relatives;

import java.util.List;
import java.util.Optional;

public interface RelativeService {
    List<Relatives> getAll();
    Optional<Relatives> getRelativeById(Integer id);
    void saveRelative(Relatives relatives);
    void deleteRelative(Integer id);


}
