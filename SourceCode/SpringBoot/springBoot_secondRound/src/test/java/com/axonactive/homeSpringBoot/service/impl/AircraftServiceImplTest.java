package com.axonactive.homeSpringBoot.service.impl;

import com.axonactive.homeSpringBoot.entity.Aircraft;
import com.axonactive.homeSpringBoot.service.AircraftService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class AircraftServiceImplTest {
    @Autowired
    AircraftService aircraftService;

    private Aircraft aircraftBoeing1;
    private Aircraft aircraftBoeing2;
    private Aircraft aircraftBoeing3;
    private Aircraft aircraftAirbus1;

    @Test
    void getAllAircrafts_shouldReturnNoData_whenTableFirstCreated() {
        assertEquals(0, aircraftService.findAll().size());
    }

    @Nested
    class AfterSaved {
        @Autowired
        AircraftService aircraftService;

        private Aircraft aircraftBoeing1;
        private Aircraft aircraftBoeing2;
        private Aircraft aircraftBoeing3;
        private Aircraft aircraftAirbus1;

        @BeforeEach
        void setup() {
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
        }

        @Test
        void findByDistanceGreaterThan_shouldReturnData_whenFound() {
            assertEquals(1, aircraftService.findByDistanceGreaterThan(10000).size());
            assertEquals(0, aircraftService.findByDistanceGreaterThan(10400).size());
        }

        @Test
        void findByTypeContaining_shouldReturnData_whenFound() {
            assertEquals(1, aircraftService.findByTypeContaining("Airbus").size());
            assertEquals(3, aircraftService.findByTypeContaining("Boeing").size());
        }
    }
}