package com.axonactive.R3SpringBootDemo.service;

import com.axonactive.R3SpringBootDemo.entity.Relative;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


public interface RelativeService {
    List<Relative> getAllRelative();

    ResponseEntity<Relative> saveRelative(Relative relative);

    void deleteRelativeById(Long id);

    Optional<Relative> findRelativeById(Long id);

    Optional<Relative> findRelativeByEmployeeId(Long empId);
}
