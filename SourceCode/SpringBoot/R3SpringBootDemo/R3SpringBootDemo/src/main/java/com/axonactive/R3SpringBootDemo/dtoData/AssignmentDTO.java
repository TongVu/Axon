package com.axonactive.R3SpringBootDemo.dtoData;

import com.axonactive.R3SpringBootDemo.entity.Employee;
import com.axonactive.R3SpringBootDemo.entity.Project;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AssignmentDTO {
    private Long id;

    private Integer numberOfHour;

    Employee employee;

    Project project;
}
