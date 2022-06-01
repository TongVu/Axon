package com.axonactive.homeSpringBoot.service.impl;

import com.axonactive.homeSpringBoot.entity.Flight;
import com.axonactive.homeSpringBoot.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RequiredArgsConstructor
class FlightServiceImplTest {
    @Autowired
    FlightService flightService;

    private Flight flight;
    private Flight flightHasDistanceMoreThan8kThanLessThan10k;
    private Flight flightDepartureFromSGNToBMV;
    private Flight flightDepartureFromSGNToDIN;

    @Test
    void getAllFlights_shouldReturnNoData_whenTableFirstCreated() {
        assertEquals(0, flightService.findAll().size());
    }


    @Nested
    class AfterSaved{
        @Autowired
        FlightService flightService;

        private Flight flight;
        private Flight flightHasDistanceMoreThan8kThanLessThan10k;
        private Flight flightDepartureFromSGNToBMV;
        private Flight flightDepartureFromSGNToDIN;

        @BeforeEach
        void setup(){
            flight = Flight.builder()
                    .id("VN315")
                    .arrivalTime(LocalTime.of(13,00,00))
                    .arrivalTerminal("DAD")
                    .departureTerminal("HAN")
                    .departureTime(LocalTime.of(11, 45, 00))
                    .distance(134)
                    .price(112)
                    .build();
            flightService.save(flight);

            flightHasDistanceMoreThan8kThanLessThan10k = Flight.builder()
                    .id("VN254")
                    .departureTerminal("SGN")
                    .arrivalTerminal("HUI")
                    .distance(10765)
                    .departureTime(LocalTime.of(18, 40, 00))
                    .arrivalTime(LocalTime.of(20, 00, 00))
                    .price(781)
                    .build();
            flightService.save(flightHasDistanceMoreThan8kThanLessThan10k);

            flightDepartureFromSGNToBMV = Flight.builder()
                    .id("VN440")
                    .departureTerminal("SGN")
                    .arrivalTerminal("BMV")
                    .distance(4081)
                    .departureTime(LocalTime.of(18, 30, 00))
                    .arrivalTime(LocalTime.of(19, 30, 00))
                    .price(426)
                    .build();
            flightService.save(flightDepartureFromSGNToBMV);

            flightDepartureFromSGNToDIN = Flight.builder()
                    .id("VN216")
                    .departureTerminal("SGN")
                    .arrivalTerminal("DIN")
                    .distance(4170)
                    .departureTime(LocalTime.of(10, 30, 00))
                    .arrivalTime(LocalTime.of(14, 20, 00))
                    .price(262)
                    .build();
            flightService.save(flightDepartureFromSGNToDIN);
        }

        @Test
        void findByDepartureTerminal_shouldReturnData_WhenFound() {
            assertEquals(1, flightService.findByDepartureTerminal("HAN").size());
        }

        @Test
        void findByDistanceGreaterThanAndDistanceLessThan_shouldReturnData_WhenFound(){
            assertEquals(1, flightService.findByDistanceGreaterThanAndDistanceLessThan(9000, 12000 ).size());
        }

        @Test
        void findByDepartureTerminalEqualsAndArrivalTerminalEquals_shouldReturnData_whenFound() {
            assertEquals(1, flightService.findByDepartureTerminalEqualsAndArrivalTerminalEquals("SGN", "BMV" ).size());
        }

        @Test
        void findAllFlightsDepartureFromSGN_shouldReturnData_WhenFound(){
            assertEquals(3, flightService.findByDepartureTerminal("SGN").size());
        }
    }
}