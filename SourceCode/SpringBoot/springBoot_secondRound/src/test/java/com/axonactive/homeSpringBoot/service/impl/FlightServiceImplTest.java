package com.axonactive.homeSpringBoot.service.impl;

import com.axonactive.homeSpringBoot.entity.Aircraft;
import com.axonactive.homeSpringBoot.entity.Flight;
import com.axonactive.homeSpringBoot.service.AircraftService;
import com.axonactive.homeSpringBoot.service.FlightService;
import com.axonactive.homeSpringBoot.service.dto.FlightWithTotalSalary;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
class FlightServiceImplTest {
    @Autowired
    FlightService flightService;

    @Test
    void getAllFlights_shouldReturnNoData_whenTableFirstCreated() {
        assertEquals(0, flightService.findAll().size());
    }

    @Nested
    class AfterSaved {
        @Autowired
        FlightService flightService;

        @Autowired
        AircraftService aircraftService;

        private Flight flight;
        private Flight flightHasDistanceMoreThan8kThanLessThan10k;
        private Flight flightDepartureFromSGNToBMV;
        private Flight flightDepartureFromSGNToDIN;
        private Flight flightVn320;
        private Flight flightFromSGNToDAD;
        private Flight flightFromDADToSGN;
        private Flight flightArrivalPQC;

        private Aircraft airbus320;
        private Aircraft boeingAircraft;

        @BeforeEach
        void setup() {
            flight = Flight.builder()
                    .id("VN315")
                    .arrivalTime(LocalTime.of(13, 00, 00))
                    .departureTerminal("HAN")
                    .arrivalTerminal("DAD")
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

            flightVn320 = Flight.builder()
                    .id("VN320")
                    .departureTerminal("SGN")
                    .arrivalTerminal("DAD")
                    .distance(2798)
                    .departureTime(LocalTime.of(6, 0, 0))
                    .arrivalTime(LocalTime.of(7, 10, 0))
                    .price(221)
                    .build();
            flightService.save(flightVn320);

            airbus320 = Aircraft.builder()
                    .type("Airbus A320")
                    .distance(4168)
                    .build();
            aircraftService.save(airbus320);

            flightFromSGNToDAD = Flight.builder()
                    .id("VN651")
                    .departureTerminal("DAD")
                    .arrivalTerminal("SGN")
                    .distance(2798)
                    .departureTime(LocalTime.of(19, 30, 0))
                    .arrivalTime(LocalTime.of(8, 0, 0))
                    .price(221)
                    .build();
            flightService.save(flightFromSGNToDAD);

            flightFromDADToSGN = Flight.builder()
                    .id("VN320")
                    .departureTerminal("SGN")
                    .arrivalTerminal("DAD")
                    .distance(2798)
                    .departureTime(LocalTime.of(6, 0, 0))
                    .arrivalTime(LocalTime.of(7, 10, 0))
                    .price(221)
                    .build();
            flightService.save(flightFromDADToSGN);

            flightArrivalPQC = Flight.builder()
                    .id("SG2PQC")
                    .departureTerminal("SGN")
                    .arrivalTerminal("PQC")
                    .distance(290)
                    .departureTime(LocalTime.of(6,0,0))
                    .arrivalTime(LocalTime.of(8,0,0))
                    .price(100)
                    .build();
            flightService.save(flightArrivalPQC);

            boeingAircraft = Aircraft.builder()
                    .type("Boeing 474")
                    .distance(4000)
                    .build();
            aircraftService.save(boeingAircraft);
        }

        @Test
        void findById_shouldReturnData_whenFound() {
            assertEquals(flightDepartureFromSGNToBMV.getId(),
                    flightService.findById("VN440").get().getId());
        }

        @Test
        void findByDepartureTerminal_shouldReturnData_WhenFound() {
            assertEquals(1, flightService.findByDepartureTerminal("HAN").size());
        }

        @Test
        void findByDistanceGreaterThanAndDistanceLessThan_shouldReturnData_WhenFound() {
            assertEquals(1, flightService.findByDistanceGreaterThanAndDistanceLessThan(9000, 12000).size());
        }

        @Test
        void findByDepartureTerminalEqualsAndArrivalTerminalEquals_shouldReturnData_whenFound() {
            assertEquals(1, flightService.findByDepartureTerminalEqualsAndArrivalTerminalEquals("SGN", "BMV").size());
        }

        @Test
        void findAllFlightsDepartureFromSGN_shouldReturnData_WhenFound() {
            assertEquals(4, flightService.findByDepartureTerminal("SGN").size());
        }

        @Test
        void findByDistanceLessThan_shouldReturnData_whenFound() {
            assertEquals(5, flightService.findByDistanceLessThan(10000).size());
        }

        @Test
        void findAllFlightCouldBeOperatedByAirbus320_shouldReturnData_whenFound() {
            assertEquals(4, flightService.findAllFlightCouldBeOperatedByAirbus320().size());
        }

        @Test
        void getRoundTripFlight_shouldReturnData_whenFound() {
            assertEquals(2, flightService.getRoundTripFlight().size());
        }

        @Test
        void getTotalFlightsFromEachDepartureTerminal_shouldReturnData_whenFound() {
            assertEquals(3, flightService.getTotalFlightsFromEachDepartureTerminal().size());
        }

        @Test
        void getTotalSalaryForEachFlight_shouldReturnData_whenFound() {
//             2 lines commented below are for testing purpose
            for (FlightWithTotalSalary flight : flightService.getTotalSalaryForEachFlight())
                System.out.println(flight);

            assertEquals(3, flightService.getTotalSalaryForEachFlight().size());
        }

        @Test
        void getAllFlightsCanOperateBeforeTwelve() {
            assertEquals(3, flightService.getAllFlightsCanOperateBeforeTwelve(LocalTime.of(12,0,0)).size());
        }

        @Test
        void findByDepartureTimeBefore() {
            assertEquals(3, flightService.findByDepartureTimeBeforeTwelve().size());
        }

        @Test
        void getTotalFlightsBeforeTwelveOfEachTerminal_shouldReturnData_whenFound() {
            assertEquals(2, flightService.getTotalFlightsBeforeTwelveOfEachTerminal(LocalTime.of(12,0,0)).size());
        }

        @Test
        void getFlightsCouldBeOperatedByBoeing() {
            assertEquals(3, flightService.getFlightsCouldBeOperatedByBoeing().size());
        }

        @Test
        void findFlightHasArrivalTerminalPQC() {
            assertEquals(1, flightService.findFlightHasArrivalTerminalPQC().size());
        }


    }
}