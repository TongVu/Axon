package com.axonactive.demo.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Table(name="projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectid;

    @NotNull
    @Size(max = 100)
    private String area;

    @NotNull
    @Size(max = 100)
    private String projectName;

    @ManyToOne
    @JoinColumn(name ="managed_department")
    private Department department;
}
