package com.hangkhong.demo.service.impl;

import com.hangkhong.demo.entity.NhanVien;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class nhanVienServiceImplTest {
    @Autowired
    nhanVienServiceImpl nhanVienService;

    @Test
    void salaryAll() {
        NhanVien nhanVien = new NhanVien(1,"Quang",100);
        nhanVienService.save(nhanVien);
        assertEquals(100,nhanVienService.salaryAll());
    }
}