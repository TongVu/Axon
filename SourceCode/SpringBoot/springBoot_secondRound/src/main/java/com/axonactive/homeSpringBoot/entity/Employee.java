package com.axonactive.homeSpringBoot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
@SqlResultSetMapping(
        name = "EmployeeWhoIsNotPilot",
        classes = {
                @ConstructorResult(
                        targetClass = com.axonactive.homeSpringBoot.service.dto.EmployeeNotPilotDTO.class,
                        columns = {
                                @ColumnResult(name = "id", type = String.class),
                                @ColumnResult(name = "name", type = String.class)})})
@NamedNativeQuery(
        name = Employee.FIND_EMPLOYEE_WHO_IS_NOT_PILOT,
        query =
                "SELECT id, name FROM employee WHERE id NOT IN ( " +
                        "SELECT employee_id FROM certificate)",
        resultSetMapping = "EmployeeWhoIsNotPilot")

public class Employee {
    public static final String FIND_EMPLOYEE_WHO_IS_NOT_PILOT = "Employee.findEmployeeWhoIsNotPilot";

    @Id
    private String id;

    @NotNull
    @Size(max = 50)
    private String name;

    @NotNull
    private Integer salary;
}
