package com.axonactive.homeSpringBoot.repository;

import com.axonactive.homeSpringBoot.entity.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Integer> {
    List<Aircraft> findByDistanceGreaterThan(Integer distance);
    List<Aircraft> findByTypeContaining(@Param("type") String type);
}
