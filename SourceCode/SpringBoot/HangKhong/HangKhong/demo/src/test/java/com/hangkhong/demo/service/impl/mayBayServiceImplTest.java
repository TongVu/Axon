package com.hangkhong.demo.service.impl;

import com.hangkhong.demo.entity.ChuyenBay;
import com.hangkhong.demo.entity.MayBay;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class mayBayServiceImplTest {
    @Autowired
    mayBayServiceImpl mayBayService;
    @Autowired
    chuyenBayServiceImpl chuyenBayService;

    MayBay mayBay;

    @BeforeEach
    void setup(){
        ChuyenBay chuyenBay = new ChuyenBay(1, "SGN", "DNA", 8000, null, null,5000000,"VN280");
        chuyenBayService.save(chuyenBay);
        mayBay = new MayBay(1,"Boeing 747", 10000);
        mayBayService.save(mayBay);
    }

    @Test
    void findMaybayCanTakeFlightVN280() {
        assertEquals(mayBay, mayBayService.findMaybayCanTakeFlightVN280().get(0));
    }
}