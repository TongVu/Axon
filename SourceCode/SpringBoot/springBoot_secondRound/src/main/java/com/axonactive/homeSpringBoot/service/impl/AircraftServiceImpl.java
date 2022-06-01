package com.axonactive.homeSpringBoot.service.impl;

import com.axonactive.homeSpringBoot.entity.Aircraft;
import com.axonactive.homeSpringBoot.repository.AircraftRepository;
import com.axonactive.homeSpringBoot.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AircraftServiceImpl implements AircraftService {
    @Autowired
    AircraftRepository aircraftRepository;

    @Override
    public List<Aircraft> findAll() {
        return aircraftRepository.findAll();
    }

    @Override
    public Aircraft save(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    @Override
    public void deleteById(Integer id) {
        aircraftRepository.deleteById(id);
    }

    @Override
    public Optional<Aircraft> findById(Integer id) {
        return aircraftRepository.findById(id);
    }

    @Override
    public List<Aircraft> findByDistanceGreaterThan(Integer distance) {
        return aircraftRepository.findByDistanceGreaterThan(distance);
    }

    @Override
    public List<Aircraft> findByTypeContaining(String type){
        return aircraftRepository.findByTypeContaining(type);
    }

}
