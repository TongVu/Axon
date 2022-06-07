package com.axonactive.demo.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull
    private String employeeid;

    @NotNull
    private LocalDate dateOfBirth;

    @NotNull
    @Size(min = 2, max = 20)
    private String firstName;

    @NotNull
    @Size(max = 10)
    private String gender;

    @NotNull
    @Size(min = 2, max = 20)
    private String lastName;

    @Size(max = 20)
    private String middleName;

    @NotNull
    private Integer salary;

    @ManyToOne
    @JoinColumn(name = "deptid")
    private Department department;

}

