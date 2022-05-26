package com.axonactive.R3SpringBootDemo.dtoData;

import com.axonactive.R3SpringBootDemo.entity.Department;
import lombok.*;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeDTO {
    private Long id;

    private String employeeid;

    private LocalDate dateOfBirth = LocalDate.of(0, 01, 01);

    private String firstName;

    private String gender;

    private String lastName;

    private String middleName;

    private Integer salary;

    private Department department;

    private Integer age;

    public Integer getAge() {
        return -this.dateOfBirth.getYear() + LocalDate.now().getYear();
    }
}
