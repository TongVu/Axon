package com.axonactive.homeSpringBoot.service.impl;

import com.axonactive.homeSpringBoot.entity.Aircraft;
import com.axonactive.homeSpringBoot.entity.Flight;
import com.axonactive.homeSpringBoot.service.AircraftService;
import com.axonactive.homeSpringBoot.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class AircraftServiceImplTest {
    @Autowired
    AircraftService aircraftService;

    @Autowired
    FlightService flightService;

    @Test
    void getAllAircrafts_shouldReturnNoData_whenTableFirstCreated() {
        assertEquals(0, aircraftService.findAll().size());
    }

    @Nested
    class AfterSaved {
        @Autowired
        AircraftService aircraftService;

        @Autowired
        FlightService flightService;
        private Aircraft aircraftBoeing1;
        private Aircraft aircraftBoeing2;
        private Aircraft aircraftBoeing3;
        private Aircraft aircraftAirbus1;
        private Aircraft aircraftBoeing747;
        private Flight flightVN280;

        @BeforeEach
        void setup() {
            flightVN280 = Flight.builder()
                    .id("VN280")
                    .departureTerminal("SGN")
                    .arrivalTerminal("HPH")
                    .distance(11979)
                    .departureTime(LocalTime.of(6, 0, 0))
                    .arrivalTime(LocalTime.of(8, 0, 0))
                    .price(1279)
                    .build();
            flightService.save(flightVN280);

            aircraftBoeing1 = Aircraft.builder()
                    .distance(10360)
                    .type("Boeing 767 - 400ER")
                    .build();
            aircraftService.save(aircraftBoeing1);

            aircraftBoeing2 = Aircraft.builder()
                    .distance(5413)
                    .type("Boeing 737 - 800")
                    .build();
            aircraftService.save(aircraftBoeing2);

            aircraftBoeing3 = Aircraft.builder()
                    .distance(5413)
                    .type("Boeing 737 - 800")
                    .build();
            aircraftService.save(aircraftBoeing3);

            aircraftAirbus1 = Aircraft.builder()
                    .distance(2888)
                    .type("Airbus A319")
                    .build();
            aircraftService.save(aircraftAirbus1);

            aircraftBoeing747 = Aircraft.builder()
                    .distance(13488)
                    .type("Boeing 747 - 400")
                    .build();
            aircraftService.save(aircraftBoeing747);
        }

        @Test
        void findByDistanceGreaterThan_shouldReturnData_whenFound() {
            assertEquals(2, aircraftService.findByDistanceGreaterThan(10000).size());
            assertEquals(1, aircraftService.findByDistanceGreaterThan(10400).size());
        }

        @Test
        void findByTypeContaining_shouldReturnData_whenFound() {
            assertEquals(1, aircraftService.findByTypeContaining("Airbus").size());
            assertEquals(4, aircraftService.findByTypeContaining("Boeing").size());
        }

        @Test
        void findAllAirCraftsCouldOperateVN280Flight_shouldReturnData_whenFound() {
            assertEquals(1, aircraftService.findAllAirCraftsCouldOperateVN280Flight().size());
        }
    }
}