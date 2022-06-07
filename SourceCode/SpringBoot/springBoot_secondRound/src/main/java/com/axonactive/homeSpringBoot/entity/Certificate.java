package com.axonactive.homeSpringBoot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
@SqlResultSetMapping(
        name="CertificateOfEmployeeCanFlyMoreThan3AircraftsAndMaxRangeOfThoseAircrafts",
        classes={
                @ConstructorResult(
                        targetClass = com.axonactive.homeSpringBoot.service.dto.CertificateOfEmployeeCanFlyMoreThan3AircraftsAndMaxRangeOfThoseAircraftsDTO.class,
                        columns={
                                @ColumnResult(name="employee_id", type = String.class),
                                @ColumnResult(name="distance", type = Integer.class)})})
@NamedNativeQuery(
        name = Certificate.FIND_EMPLOYEE_CAN_FLY_MORE_THAN_3_AIRCRAFTS_AND_MAX_RANGE_OF_THOSE_AIRCRAFTS,
        query = "SELECT employee_id, MAX(distance) AS distance " +
        "FROM certificate JOIN aircraft USING(id) " +
        "WHERE employee_id IN (SELECT employee_id " +
            "FROM certificate "+
            "GROUP BY employee_id HAVING COUNT(aircraft_id) > 3) " +
        "GROUP BY employee_id",
        resultSetMapping = "CertificateOfEmployeeCanFlyMoreThan3AircraftsAndMaxRangeOfThoseAircrafts")

@NamedNativeQuery(
        name = Certificate.FIND_EMPLOYEE_CAN_FLY_BOEING_AND_AIRBUS,
        query = "SELECT employee_id FROM certificate " +
                "WHERE aircraft_id IN (SELECT id FROM aircraft WHERE LOWER(type) LIKE '%boeing%') " + //should be dynamic param

                        "INTERSECT " +

                "SELECT employee_id FROM certificate " +
                "WHERE aircraft_id IN (SELECT aircraft_id FROM aircraft WHERE LOWER(type) LIKE '%airbus%')",
        resultClass = Certificate.class)
public class Certificate {
    public static final String FIND_EMPLOYEE_CAN_FLY_MORE_THAN_3_AIRCRAFTS_AND_MAX_RANGE_OF_THOSE_AIRCRAFTS = "Certificate.findEmployeeCanFlyMoreThan3AicraftsAndMaxRangeOfThoseAircrafts";
    public static final String FIND_EMPLOYEE_CAN_FLY_BOEING_AND_AIRBUS = "Certificate.findEmployeeCanFlyBoeingAndAirbus";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "employee_id")
    Employee employee;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "aircraft_id")
    Aircraft aircraft;
}
