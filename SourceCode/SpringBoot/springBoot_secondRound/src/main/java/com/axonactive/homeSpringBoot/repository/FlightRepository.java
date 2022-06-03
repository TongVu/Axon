package com.axonactive.homeSpringBoot.repository;

import com.axonactive.homeSpringBoot.entity.Flight;
import com.axonactive.homeSpringBoot.service.dto.FlightFromAToBAndFromBToADTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    Optional<Flight> findById(String id);

    List<Flight> findByDepartureTerminal(String departureTerminal);

    List<Flight> findByDistanceGreaterThanAndDistanceLessThan(int min, int max);

    List<Flight> findByDepartureTerminalEqualsAndArrivalTerminalEquals(String departureTerminal, String arrivalTerminal);

    List<Flight> findByDistanceLessThan(Integer distance);

    @Query("SELECT new com.axonactive.demo.service.dto.FlightFromAToBAndFromBToADTO() " +
            "FROM Flight a, Flight b WHERE a.departureTerminal = b.arrivalTerminal " +
            "AND a.arrivalTerminal = b.departureTerminal")
    List<FlightFromAToBAndFromBToADTO> getRoundTripFlight();
}
