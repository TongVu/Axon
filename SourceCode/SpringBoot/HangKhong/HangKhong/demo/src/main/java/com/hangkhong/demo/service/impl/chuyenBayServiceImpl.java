package com.hangkhong.demo.service.impl;

import com.hangkhong.demo.dto.ChuyenBayDto;
import com.hangkhong.demo.entity.ChuyenBay;
import com.hangkhong.demo.entity.MayBay;
import com.hangkhong.demo.repository.chuyenBayRepo;
import com.hangkhong.demo.repository.mayBayRepo;
import com.hangkhong.demo.service.chuyenBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class chuyenBayServiceImpl implements chuyenBayService {
    @Autowired
    private chuyenBayRepo chuyenBayRepo;

    @Autowired
    private mayBayRepo mayBayRepo;

    @Override
    public List<ChuyenBay> getAll() {
        return chuyenBayRepo.findAll();
    }

    @Override
    public Optional<ChuyenBay> getById(Integer id) {
        return chuyenBayRepo.findById(id);
    }

    @Override
    public void save(ChuyenBay chuyenBay) {
        chuyenBayRepo.save(chuyenBay);
    }

    @Override
    public void deleteById(Integer id) {
        chuyenBayRepo.deleteById(id);
    }

    @Override
    public ChuyenBay toChuyenBayEntity(ChuyenBayDto chuyenBayDto) {
        return new ChuyenBay(chuyenBayDto.getMaCb(),chuyenBayDto.getGaDi(),chuyenBayDto.getGaDen()
                ,chuyenBayDto.getGioDi(),chuyenBayDto.getGioDen());
    }

    @Override
    public List<ChuyenBay> toChuyenBayEntity(List<ChuyenBayDto> chuyenBayDtos) {
        List<ChuyenBay> chuyenBayList=new ArrayList<>();
        for (ChuyenBayDto chuyenBay:chuyenBayDtos
             ) {
            chuyenBayList.add(new ChuyenBay(chuyenBay.getMaCb(),chuyenBay.getGaDi(),chuyenBay.getGaDen(),
                    chuyenBay.getGioDi(),chuyenBay.getGioDen()));
        }
        return chuyenBayList;
    }

    @Override
    public List<ChuyenBayDto> toChuyenBayDTO(List<ChuyenBay> chuyenBayList) {
        List<ChuyenBayDto> chuyenBayDtos=new ArrayList<>();
        for (ChuyenBay chuyenBay:chuyenBayList
        ) {
            chuyenBayDtos.add(new ChuyenBayDto(chuyenBay.getMaCb(),chuyenBay.getGaDi(),chuyenBay.getGaDen(),
                    chuyenBay.getGioDi(),chuyenBay.getGioDen()));
        }
        return chuyenBayDtos;
    }

    @Override
    public ChuyenBayDto toChuyenBayDTO(ChuyenBay chuyenBay) {
        return new ChuyenBayDto(chuyenBay.getMaCb(),chuyenBay.getGaDi(),chuyenBay.getGaDen(),chuyenBay.getGioDi(),chuyenBay.getGioDen());
    }

    @Override
    public Integer countByGaDen(String gaDen) {
        List<ChuyenBay> chuyenBayList = chuyenBayRepo.findByGaDen(gaDen);
        return chuyenBayList.size();
    }

    @Override
    public ChuyenBay findByMaCbFake(String maCbFake) {
        return chuyenBayRepo.findByMaCbFake(maCbFake);
    }

    @Override
    public List<ChuyenBay> findByDoDaiLesserThan(Integer doDai) {
        return chuyenBayRepo.findByDoDaiLesserThan(doDai);
    }

    @Override
    public List<ChuyenBay> findChuyenBayFlighttableByA320() {
        MayBay mayBay = mayBayRepo.findByLoaiMayBay("A320");
        return chuyenBayRepo.findByDoDaiLesserThan(mayBay.getTamBay());
    }

    @Override
    public List<ChuyenBay> findByGioDiBefore(LocalDate date) {
        return chuyenBayRepo.findByGioDiBefore(date);
    }

}
