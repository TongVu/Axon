package com.axonactive.homeSpringBoot.service;

import com.axonactive.homeSpringBoot.entity.Flight;

import java.util.List;
import java.util.Optional;

public interface FlightService {
    List<Flight> findAll();
    Optional<Flight> findById(Integer id);
    Flight save(Flight flight);
    void deleteById(Integer id);

    List<Flight> findByDepartureTerminal(String departureTerminal);
    List<Flight> findByDistanceGreaterThanAndDistanceLessThan(int min, int max);
    List<Flight> findByDepartureTerminalEqualsAndArrivalTerminalEquals(String departureTerminal, String arrivalTerminal);
}
