package com.hangkhong.demo.service.impl;

import com.hangkhong.demo.entity.ChungNhan;
import com.hangkhong.demo.entity.MayBay;
import com.hangkhong.demo.entity.NhanVien;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class chungNhanServiceImplTest {
    @Autowired
    chungNhanServiceImpl chungNhanService;
    @Autowired
    nhanVienServiceImpl nhanVienService;
    @Autowired
    mayBayServiceImpl mayBayService;

    private NhanVien nhanVien1, nhanVien2;
    private MayBay mayBay1, mayBat2;
    private ChungNhan chungNhan1, chungNhan2;

    @BeforeEach
    void setup(){
        NhanVien nhanVien1 = new NhanVien(1,"Quang",100);
        NhanVien nhanVien2 = new NhanVien(2,"Minh",200);
        nhanVienService.save(nhanVien1);
        nhanVienService.save(nhanVien2);

        MayBay mayBay1 = new MayBay(1,"Boeing 747", 10000);
        MayBay mayBay2 = new MayBay(2,"Boeing 700", 8000);
        mayBayService.save(mayBay1);
        mayBayService.save(mayBay2);

        ChungNhan chungNhan1 = new ChungNhan(1,nhanVien1,mayBay1);
        ChungNhan chungNhan2 = new ChungNhan(2,nhanVien2,mayBay2);
        chungNhanService.save(chungNhan1);
        chungNhanService.save(chungNhan2);

    }


//    @Test
//    void findByMayBayId() {
//        assertEquals(mayBay1,chungNhanService.findByMayBayMamb(1).getId());
//    }

}