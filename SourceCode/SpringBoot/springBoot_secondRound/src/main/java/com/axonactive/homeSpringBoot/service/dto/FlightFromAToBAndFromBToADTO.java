package com.axonactive.homeSpringBoot.service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FlightFromAToBAndFromBToADTO {
    private String departureTerminal;

    private String arrivalTerminal;

    private Integer distance;

    private LocalTime departureTime;

    private LocalTime arrivalTime;

    private double price;
}
