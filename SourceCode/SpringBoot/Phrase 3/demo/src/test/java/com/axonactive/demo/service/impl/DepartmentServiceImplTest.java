package com.axonactive.demo.service.impl;

import com.axonactive.demo.entity.Department;
import com.axonactive.demo.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class DepartmentServiceImplTest {

   @Autowired
   DepartmentService departmentService;

    @Test
    void testGetAllDepartment_shouldReturnNoData_whenJustCreateTable(){
        List<Department> departments = departmentService.getALl();
        assertEquals(0,departments.size());
    }
}