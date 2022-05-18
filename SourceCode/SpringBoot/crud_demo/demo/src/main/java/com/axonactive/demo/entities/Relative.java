package com.axonactive.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "relatives")
public class Relative {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=255)
    private String fullName;

    @NotNull
    private int gender;

    @NotNull
    @Size(max=255)
    private String phoneNumber;

    @NotNull
    @Size(max=255)
    private String relationship;

    @ManyToOne
    @JoinColumn (name = "employeeid")
    private Employee employee;
}
