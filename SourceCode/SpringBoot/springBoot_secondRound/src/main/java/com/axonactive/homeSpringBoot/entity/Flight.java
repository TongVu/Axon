package com.axonactive.homeSpringBoot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table
@NamedNativeQuery(
        name = Flight.FIND_FLIGHT_HAS_ARRIVAL_TERMINAL_IS_PQC,
        query = "SELECT * " +
                "FROM flight " +
                "WHERE arrival_terminal = 'PQC'",
        resultClass = Flight.class)
public class Flight {
    public static final String FIND_FLIGHT_HAS_ARRIVAL_TERMINAL_IS_PQC = "Flight.findFlightHasArrivalTerminalIsPqc";
    @Id
    private String id;

    @NotNull
    @Size(max = 50 )
    private String departureTerminal;

    @NotNull
    @Size(max = 50 )
    private String arrivalTerminal;

    @NotNull
    private Integer distance;

    @NotNull
    private LocalTime departureTime;

    @NotNull
    private LocalTime arrivalTime;

    @NotNull
    private double price;
}
