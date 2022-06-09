package com.axonactive.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;


    private String area;

    @Column(unique = true,length = 100)
    private String projectName;

    @JoinColumn
    @ManyToOne
    private Department department;
}
