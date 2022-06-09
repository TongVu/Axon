package com.axonactive.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate dateOfBirth;

    @Column(length = 30)
    private String firstName;

    @Column(length = 10)
    private String gender;

    @Column(length = 30)
    private String lastName;

    @Column(length = 50)
    private String middleName;

    private Integer salary;


    @JoinColumn
    @ManyToOne
    private Department department;
}
