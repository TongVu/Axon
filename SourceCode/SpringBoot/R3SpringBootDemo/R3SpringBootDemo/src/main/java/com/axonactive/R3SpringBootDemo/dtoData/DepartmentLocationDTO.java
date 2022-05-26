package com.axonactive.R3SpringBootDemo.dtoData;

import com.axonactive.R3SpringBootDemo.entity.Department;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DepartmentLocationDTO {
    private Long id;
    private String location;
    private Department department;
}
