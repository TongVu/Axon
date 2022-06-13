package com.axonactive.companyspringrun2.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @Column(length = 9)
    private String id;

    private LocalDate dateOfBirth;

    @NotNull
    @Column(length = 20)
    private String firstName;

    @Column(length = 20)
    private String middleName;

    @NotNull
    @Column(length = 20)
    private String lastName;

    @NotNull
    @Column(length = 10)
    private String gender;

    @NotNull
    private Integer salary;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;





}
