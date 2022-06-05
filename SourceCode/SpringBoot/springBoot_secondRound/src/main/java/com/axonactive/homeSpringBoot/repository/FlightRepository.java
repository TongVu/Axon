package com.axonactive.homeSpringBoot.repository;

import com.axonactive.homeSpringBoot.entity.Flight;
import com.axonactive.homeSpringBoot.service.dto.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    Optional<Flight> findById(String id);

    List<Flight> findByDepartureTerminal(String departureTerminal);

    List<Flight> findByDistanceGreaterThanAndDistanceLessThan(int min, int max);

    List<Flight> findByDepartureTerminalEqualsAndArrivalTerminalEquals(String departureTerminal, String arrivalTerminal);

    List<Flight> findByDistanceLessThan(Integer distance);

    @Query("SELECT new com.axonactive.homeSpringBoot.service.dto.FlightFromAToBAndFromBToADTO(a.departureTerminal, a.arrivalTerminal, a.distance, a.departureTime, a.arrivalTime, a.price) " +
            "FROM Flight a, Flight b WHERE a.departureTerminal = b.arrivalTerminal AND a.arrivalTerminal = b.departureTerminal")
    List<FlightFromAToBAndFromBToADTO> getRoundTripFlight();

    @Query("SELECT new com.axonactive.homeSpringBoot.service.dto.FlightFromEachDepartureTerminalDTO(departureTerminal, COUNT(id)) " +
            "FROM Flight GROUP BY departureTerminal")
    List<FlightFromEachDepartureTerminalDTO> getTotalFlightsFromEachDepartureTerminal();

    @Query("SELECT new com.axonactive.homeSpringBoot.service.dto.FlightWithTotalSalary(departureTerminal, SUM(price)) " +
    "FROM Flight GROUP BY departureTerminal")
    List<FlightWithTotalSalary>  getTotalSalaryForEachFlight();

    @Query("SELECT new com.axonactive.homeSpringBoot.service.dto.FlightCanOperateBeforeTwelveDTO (id) " +
    "FROM Flight WHERE departureTime < ?1 ")
    List<FlightCanOperateBeforeTwelveDTO> getAllFlightsCanOperateBeforeTwelve(LocalTime timeDeparture);

    List<Flight> findByDepartureTimeBefore(LocalTime time);

    @Query("SELECT new com.axonactive.homeSpringBoot.service.dto.FlightBeforeTwelveOfEachTerminalDTO (departureTerminal, COUNT(id)) " +
            "FROM Flight WHERE departureTime < ?1 GROUP BY departureTerminal")
    List<FlightBeforeTwelveOfEachTerminalDTO> getTotalFlightsBeforeTwelveOfEachTerminal(LocalTime departureTime);

    @Query("SELECT new com.axonactive.homeSpringBoot.service.dto.FlightCouldBeOperatedByBoeingDTO(id, distance) " +
            "FROM Flight WHERE distance < (SELECT MIN(distance) FROM Aircraft WHERE LOWER(type) LIKE '%boeing%')")
    List<FlightCouldBeOperatedByBoeingDTO> getFlightsCouldBeOperatedByBoeing();

}

