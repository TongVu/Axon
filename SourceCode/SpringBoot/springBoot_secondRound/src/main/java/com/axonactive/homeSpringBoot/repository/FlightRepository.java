package com.axonactive.homeSpringBoot.repository;

import com.axonactive.homeSpringBoot.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    List<Flight> findByDepartureTerminal(String departureTerminal);

    List<Flight> findByDistanceGreaterThanAndDistanceLessThan(int min, int max);

    List<Flight> findByDepartureTerminalEqualsAndArrivalTerminalEquals(String departureTerminal, String arrivalTerminal);

}
