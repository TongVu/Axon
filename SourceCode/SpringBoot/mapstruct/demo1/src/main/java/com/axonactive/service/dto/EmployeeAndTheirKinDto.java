package com.axonactive.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.axonactive.demo.entity.Relatives;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeAndTheirKinDto {
    private String name;
    private Integer id;
    private List<Relatives> relativesList;
}
