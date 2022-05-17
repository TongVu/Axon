package com.axonactive.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Employee {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    @NotNull
    @Size(max = 9)
    private String employeeid;

    @NotNull
    private Date dob;

    @NotNull
    @Size(min = 1, max = 20)
    private String firstName;

    @NotNull
    @Size(max = 10)
    private String gender;

    @NotNull
    @Size(min = 1, max = 20)
    private String lastName;

    @NotNull
    @Size(min = 1, max = 20)
    private String middleName;

    @NotNull
    private Integer salary;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "deptid")
    private Department deparment;
}
