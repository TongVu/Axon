package com.axonactive.demo1;

import com.axonactive.demo.entity.Relatives;
import com.axonactive.demo.entity.Location;
import com.axonactive.service.RelativeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class RelativesTest {
    @Autowired
    RelativeService relativeService;

    @Test
    void testGetAll_shouldReturn0_whenJustCreatedTable() {
        Assertions.assertEquals(0, relativeService.getAll().size());
    }

    @Test
    void testAdd_shouldReturnOne_whenAddOne() {
        Relatives relative = Relatives.builder()
                .build();
        relativeService.saveRelative(relative);
        Assertions.assertEquals(1, relativeService.getAll().size());
    }

    @Test
    void testGetId_shouldReturnTrue_whenIdExist() {
        Relatives relative = Relatives.builder()
                .build();
        relativeService.saveRelative(relative);
        int id = relativeService.
                getRelativeById(relative.getId()).
                get().getId();
        Assertions.assertEquals(relative.getId(), id);
    }

    @Test
    void testGetId_ShouldReturnTrue_whenIdNotExist() {
        boolean result = false;
        for (Relatives entity : relativeService.getAll()
        ) {
            if (entity.getId() == 100000000)
                result = true;
        }
        Assertions.assertFalse(result);
    }

    @Test
    void testAdd_shouldReturnFalse_whenDeleteOne() {
        Relatives relative = Relatives.builder()
                .build();
        relativeService.saveRelative(relative);
        relativeService.deleteRelative(relative.getId());
        boolean result = false;
        for (Relatives entity : relativeService.getAll()
        ) {
            if (Objects.equals(entity.getId(), relative.getId()))
                result = true;
        }
        Assertions.assertFalse(result);
    }
}
