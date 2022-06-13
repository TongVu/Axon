package com.axonactive.companyspringrun2.Entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentLocation {

    @Id
    private Integer id;

    @Column(length = 100)
    private String location;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;
}
