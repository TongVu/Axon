package com.axonactive.demo.entity;

import com.axonactive.demo.service.GenderAttributeConverter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.YearMonth;

@Entity
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String firstName;

    @Convert(converter = GenderAttributeConverter.class)
    private Gender gender;

    private YearMonth yearMonth;

    @ManyToOne
    @JoinColumn(name="dept_id")
    private Department department;

}
