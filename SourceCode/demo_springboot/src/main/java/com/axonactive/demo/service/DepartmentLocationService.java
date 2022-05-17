package com.axonactive.demo.service;

import com.axonactive.demo.entity.Department;
import com.axonactive.demo.entity.DepartmentLocation;

import java.util.List;

public interface DepartmentLocationService {
    List<DepartmentLocation> getAll();
}
