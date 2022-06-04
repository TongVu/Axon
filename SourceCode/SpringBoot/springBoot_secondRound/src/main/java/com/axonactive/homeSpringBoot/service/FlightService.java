package com.axonactive.homeSpringBoot.service;

import com.axonactive.homeSpringBoot.entity.Flight;
import com.axonactive.homeSpringBoot.service.dto.FlightCanOperateBeforeTwelveDTO;
import com.axonactive.homeSpringBoot.service.dto.FlightFromAToBAndFromBToADTO;
import com.axonactive.homeSpringBoot.service.dto.FlightFromEachDepartureTerminalDTO;
import com.axonactive.homeSpringBoot.service.dto.FlightWithTotalSalary;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface FlightService {
    List<Flight> findAll();
    Optional<Flight> findById(String id);
    Flight save(Flight flight);
    void deleteById(Integer id);

    List<Flight> findByDepartureTerminal(String departureTerminal);
    List<Flight> findByDistanceGreaterThanAndDistanceLessThan(int min, int max);
    List<Flight> findByDepartureTerminalEqualsAndArrivalTerminalEquals(String departureTerminal, String arrivalTerminal);
    List<Flight> findByDistanceLessThan(Integer distance);
    List<Flight> findAllFlightCouldBeOperatedByAirbus320();
    List<FlightFromAToBAndFromBToADTO> getRoundTripFlight();
    List<FlightFromEachDepartureTerminalDTO>  getTotalFlightsFromEachDepartureTerminal();
    List<FlightWithTotalSalary> getTotalSalaryForEachFlight();
    List<FlightCanOperateBeforeTwelveDTO> getAllFlightsCanOperateBeforeTwelve(LocalTime timeDeparture);
    List<Flight> findByDepartureTimeBeforeTwelve();
}
