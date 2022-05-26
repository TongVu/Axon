package com.axonactive.R3SpringBootDemo.dtoData;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DepartmentDTO {
    private Long id;

    private String departmentName;

    private LocalDate startDate ;
}
