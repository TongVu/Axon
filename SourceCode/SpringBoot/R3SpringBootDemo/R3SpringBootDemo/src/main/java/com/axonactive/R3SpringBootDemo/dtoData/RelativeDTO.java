package com.axonactive.R3SpringBootDemo.dtoData;

import com.axonactive.R3SpringBootDemo.entity.Employee;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RelativeDTO {
    private Long id;

    private String fullName;

    private int gender;

    private String phoneNumber;

    private String relationship;

    private Employee employee;
}
