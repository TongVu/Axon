package com.axonactive.service.dto;

import com.axonactive.demo.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AreaReportWithProjectAndEmployee {
    private List<Project> projectList;

    private Integer numberOfEmployee;

    private Integer count;
}
