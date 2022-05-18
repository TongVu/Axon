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
@Table
public class DepartmentLocation {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    private String location;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "deptid")
    private Department department;
}

