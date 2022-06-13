package com.axonactive.companyspringrun2.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Department {

    @Id
    private Integer id;

    @Column(length = 200)
    @NotNull
    private String departmentName;

    @NotNull
    private LocalDate startDate;

}
