package com.axonactive.R3SpringBootDemo.entity;

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
    private LocalDate dateOfBirth = LocalDate.of(0, 01, 01);

    @NotNull
    @Size(min = 1, max = 20)
    private String firstName;

    @NotNull
    @Size(max = 10)
    private String gender;

    @NotNull
    @Size( max = 20)
    private String lastName;

    @Size(max = 20)
    private String middleName;

    @NotNull
    private Integer salary;

    @ManyToOne
    @JoinColumn(name = "deptid")
    private Department department;

    //violate singleton pattern
    @Transient
    private Integer age;

    public Integer getAge() {
        return -this.dateOfBirth.getYear() + LocalDate.now().getYear();
    }
}
