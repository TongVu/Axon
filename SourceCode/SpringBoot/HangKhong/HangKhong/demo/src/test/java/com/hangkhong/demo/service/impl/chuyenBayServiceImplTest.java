package com.hangkhong.demo.service.impl;

import com.hangkhong.demo.entity.ChuyenBay;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class chuyenBayServiceImplTest {
    @Autowired
    chuyenBayServiceImpl chuyenBayService;

//    @Test
//    void countByGaDen() {
//        ChuyenBay chuyenBay = new ChuyenBay(1,"DNA","SGN",null,null);
//        chuyenBayService.save(chuyenBay);
//        assertEquals(1,chuyenBayService.countByGaDen("SGN"));
//    }
}