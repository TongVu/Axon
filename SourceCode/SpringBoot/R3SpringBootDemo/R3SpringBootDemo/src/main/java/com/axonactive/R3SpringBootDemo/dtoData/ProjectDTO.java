package com.axonactive.R3SpringBootDemo.dtoData;

import com.axonactive.R3SpringBootDemo.entity.Department;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProjectDTO {
    private Long projectid;

    private String area;

    private String projectName;

    private Department department;
}
