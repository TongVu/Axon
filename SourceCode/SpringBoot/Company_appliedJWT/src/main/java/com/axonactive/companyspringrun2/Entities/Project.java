package com.axonactive.companyspringrun2.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Project {

    @Id
    private Integer id;

    @Column(length = 255)
    private String area;

    @NotNull
    @Column(length = 100,unique = true)
    private String projectName;

    @ManyToOne
    @JoinColumn(name = "managed_department")
    private Department department;

}
