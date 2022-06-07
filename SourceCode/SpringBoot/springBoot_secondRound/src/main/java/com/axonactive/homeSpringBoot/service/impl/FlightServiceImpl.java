package com.axonactive.homeSpringBoot.service.impl;

import com.axonactive.homeSpringBoot.entity.Aircraft;
import com.axonactive.homeSpringBoot.entity.Flight;
import com.axonactive.homeSpringBoot.repository.FlightRepository;
import com.axonactive.homeSpringBoot.service.AircraftService;
import com.axonactive.homeSpringBoot.service.FlightService;
import com.axonactive.homeSpringBoot.service.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    AircraftService aircraftService;

    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    public Optional<Flight> findById(String id) {
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
    public List<Flight> findByDistanceGreaterThanAndDistanceLessThan(int min, int max) {
        return flightRepository.findByDistanceGreaterThanAndDistanceLessThan(min, max);
    }

    @Override
    public List<Flight> findByDepartureTerminalEqualsAndArrivalTerminalEquals(String departureTerminal, String arrivalTerminal) {
        return flightRepository.findByDepartureTerminalEqualsAndArrivalTerminalEquals(departureTerminal, arrivalTerminal);
    }

    public List<Flight> findAllFlightsDepartureFromSGN() {
        return flightRepository.findByDepartureTerminal("SGN");
    }

    @Override
    public List<Flight> findByDistanceLessThan(Integer distance) {
        return flightRepository.findByDistanceLessThan(distance);
    }

    @Override
    public List<Flight> findAllFlightCouldBeOperatedByAirbus320() {
        Aircraft aircraft = aircraftService.findByTypeContaining("Airbus A320").get(0);
        List<Flight> flightSCouldOperatedByAirbus320 = flightRepository.findByDistanceLessThan(aircraft.getDistance());

        return flightSCouldOperatedByAirbus320;
    }

    @Override
    public List<FlightFromAToBAndFromBToADTO> getRoundTripFlight() {
        return flightRepository.getRoundTripFlight();
    }

    @Override
    public List<FlightFromEachDepartureTerminalDTO> getTotalFlightsFromEachDepartureTerminal() {
        return flightRepository.getTotalFlightsFromEachDepartureTerminal();
    }
    @Override
    public List<FlightWithTotalSalary> getTotalSalaryForEachFlight(){
        return flightRepository.getTotalSalaryForEachFlight();
    }

    @Override
    public List<FlightCanOperateBeforeTwelveDTO> getAllFlightsCanOperateBeforeTwelve(LocalTime timeDeparture){
        return flightRepository.getAllFlightsCanOperateBeforeTwelve(LocalTime.of(12,0,0));
    }

    @Override
    public List<Flight> findByDepartureTimeBeforeTwelve(){
        return flightRepository.findByDepartureTimeBefore(LocalTime.of(12,0,0));
    }

    @Override
    public List<FlightBeforeTwelveOfEachTerminalDTO> getTotalFlightsBeforeTwelveOfEachTerminal(LocalTime departureTime){
        return flightRepository.getTotalFlightsBeforeTwelveOfEachTerminal(LocalTime.of(12,0,0));
    }
    @Override
    public List<FlightCouldBeOperatedByBoeingDTO> getFlightsCouldBeOperatedByBoeing(){
        return flightRepository.getFlightsCouldBeOperatedByBoeing();
    }

    @Override
    public List<Flight> findFlightHasArrivalTerminalPQC(){
        return flightRepository.findFlightHasArrivalTerminalIsPqc();
    }
}
