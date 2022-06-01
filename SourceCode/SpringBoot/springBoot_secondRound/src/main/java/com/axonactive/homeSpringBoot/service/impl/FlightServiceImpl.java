package com.axonactive.homeSpringBoot.service.impl;

import com.axonactive.homeSpringBoot.entity.Flight;
import com.axonactive.homeSpringBoot.repository.FlightRepository;
import com.axonactive.homeSpringBoot.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    FlightRepository flightRepository;

    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    public Optional<Flight> findById(Integer id) {
        return flightRepository.findById(id);
    }

    @Override
    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public void deleteById(Integer id) {
        flightRepository.deleteById(id);
    }

    @Override
    public List<Flight> findByDepartureTerminal(String departureTerminal) {
        return flightRepository.findByDepartureTerminal(departureTerminal);
    }

    @Override
    public List<Flight> findByDistanceGreaterThanAndDistanceLessThan(int min, int max){
        return flightRepository.findByDistanceGreaterThanAndDistanceLessThan(min, max);
    }

    @Override
    public List<Flight> findByDepartureTerminalEqualsAndArrivalTerminalEquals(String departureTerminal, String arrivalTerminal) {
        return flightRepository.findByDepartureTerminalEqualsAndArrivalTerminalEquals(departureTerminal, arrivalTerminal);
    }

    public List<Flight> findAllFlightsDepartureFromSGN(){
        return flightRepository.findByDepartureTerminal("SGN");
    }
}
