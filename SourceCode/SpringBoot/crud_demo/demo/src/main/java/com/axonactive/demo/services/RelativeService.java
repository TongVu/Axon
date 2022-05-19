package com.axonactive.demo.services;

import com.axonactive.demo.entities.Project;
import com.axonactive.demo.entities.Relative;

import java.util.List;
import java.util.Optional;


public interface RelativeService {
    List<Relative> getAllRelative();

    void saveRelative(Relative relative);

    void deleteRelativeById(Long id);

    Optional<Relative> findRelativeById(Long id);

}
