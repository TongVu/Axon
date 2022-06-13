package com.axonactive.companyspringrun2.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Relatives {

    @Id
    private Integer id;

    @Column(length = 255)
    @NotNull
    private String fullName;

    @NotNull
    private Integer gender;

    @Column(length = 255,unique = true)
    @NotNull
    private String phoneNumber;

    @NotNull
    @Column(length = 255)
    private String relationship;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
