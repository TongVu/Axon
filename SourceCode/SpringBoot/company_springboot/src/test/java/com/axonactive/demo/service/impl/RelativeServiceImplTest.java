package com.axonactive.demo.service.impl;

import com.axonactive.demo.service.RelativeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RelativeServiceImplTest {
    @Autowired
    RelativeService relativeService;

    @Test
    void getAll_shouldReturnNoData_whenTableJustCreated() {
        assertEquals(0, relativeService.getAll().size());
    }
}