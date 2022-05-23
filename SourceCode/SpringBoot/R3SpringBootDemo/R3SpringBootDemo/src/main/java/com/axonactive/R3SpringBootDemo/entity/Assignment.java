package com.axonactive.R3SpringBootDemo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "assignments")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer numberOfHour;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "employeeid")
    Employee employee;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "projectid")
    Project project;
}
