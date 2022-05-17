package com.axonactive.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Relative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String fullName;

    @NotNull
    private int gender;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String relationship;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "employeeid")
    private Employee employee;
}
