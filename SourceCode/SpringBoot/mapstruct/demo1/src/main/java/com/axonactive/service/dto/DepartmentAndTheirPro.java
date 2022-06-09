package com.axonactive.service.dto;

import com.axonactive.demo.entity.Department;
import com.axonactive.demo.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentAndTheirPro {
    private Integer deptId;
    private List<Project> projectList;
    private String departmentName;
    private Department department;
    public DepartmentAndTheirPro(Integer deptId, List<Project> projectList) {
        this.deptId = deptId;
        this.projectList = projectList;
    }

    public DepartmentAndTheirPro(List<Project> projectList, String departmentName) {
        this.projectList = projectList;
        this.departmentName = departmentName;
    }

    public DepartmentAndTheirPro( Department department,List<Project> projectList) {
        this.projectList = projectList;
        this.department = department;
    }
}
