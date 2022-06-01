package com.axonactive.homeSpringBoot.service;

import com.axonactive.homeSpringBoot.entity.Aircraft;

import java.util.List;
import java.util.Optional;

public interface AircraftService {
    List<Aircraft> findAll();
    Optional<Aircraft> findById(Integer id);
    Aircraft save(Aircraft aircraft);
    void deleteById(Integer id);

    List<Aircraft> findByDistanceGreaterThan(Integer distance);
    List<Aircraft> findByTypeContaining(String type);
}
