package com.axonactive.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import net.bytebuddy.description.field.FieldDescription;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "assignments")
public class Assignment {
    @NotNull
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
