package com.axonactive.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@Table(name = "comp_department")
@SqlResultSetMapping(
        name="DepartmentEmployeeStatistics",
        classes={
                @ConstructorResult(
                        targetClass = com.axonactive.demo.service.dto.DepartmentStatisticsDto.class,
                        columns={
                                @ColumnResult(name="departmentName", type = String.class),
                                @ColumnResult(name="numberOfEmployee", type = Long.class)})})
@NamedNativeQuery(
        name = Department.COUNT_EMPLOYEES_IN_DEPARTMENT,
        query = "SELECT d.name as departmentName, count(e.id) as numberOfEmployee " +
                "FROM comp_department d left join employee e on d.id = e.dept_id " +
                "GROUP BY d.name ORDER BY d.name",
        resultSetMapping = "DepartmentEmployeeStatistics")
@Entity
public class Department {
    public static final String COUNT_EMPLOYEES_IN_DEPARTMENT = "Department.countEmployeesInDepartments";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Location location;
}
