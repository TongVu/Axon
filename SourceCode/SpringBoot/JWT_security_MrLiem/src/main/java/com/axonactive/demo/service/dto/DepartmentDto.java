package com.axonactive.demo.service.dto;

import com.axonactive.demo.entity.Location;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartmentDto {
    private String name;
    private Location location;

}
