package com.hangkhong.demo.service.impl;

import com.hangkhong.demo.dto.MayBayDto;
import com.hangkhong.demo.entity.ChuyenBay;
import com.hangkhong.demo.entity.MayBay;
import com.hangkhong.demo.repository.chuyenBayRepo;
import com.hangkhong.demo.repository.mayBayRepo;
import com.hangkhong.demo.service.mayBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class mayBayServiceImpl implements mayBayService {
    @Autowired
    private mayBayRepo mayBayRepository;
    @Autowired
    private com.hangkhong.demo.repository.chuyenBayRepo chuyenBayRepo;

    @Override
    public List<MayBay> getAll() {
        return mayBayRepository.findAll();
    }

    @Override
    public Optional<MayBay> getById(Integer id) {
        return mayBayRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
    mayBayRepository.deleteById(id);
    }

    @Override
    public void save(MayBay mayBay) {
        mayBayRepository.save(mayBay);
    }

    @Override
    public MayBay toMayBayEntity(MayBayDto mayBayDto) {
        return new MayBay(mayBayDto.getMamb(),mayBayDto.getLoaiMayBay(),mayBayDto.getTamBay());
    }

    @Override
    public List<MayBay> toMayBayEntity(List<MayBayDto> mayBayDtos) {
        List<MayBay> mayBayList=new ArrayList<>();
        for (MayBayDto mayBay: mayBayDtos
             ) {
            mayBayList.add(new MayBay(mayBay.getMamb(),mayBay.getLoaiMayBay()
                    ,mayBay.getTamBay()));
        }
        return mayBayList;
    }

    @Override
    public List<MayBayDto> toMayBayDTO(List<MayBay> mayBayList) {
        List<MayBayDto> mayBayDtos=new ArrayList<>();
        for (MayBay mayBay: mayBayList
        ) {
            mayBayDtos.add(new MayBayDto(mayBay.getMamb(),mayBay.getLoaiMayBay()
                    ,mayBay.getTamBay()));
        }
        return mayBayDtos;
    }

    @Override
    public MayBayDto toMayBayDTO(MayBay mayBay) {
        return new MayBayDto(mayBay.getMamb(),mayBay.getLoaiMayBay(),mayBay.getTamBay());
    }

    @Override
    public List<MayBay> findByLoaiMayBayLike(String loaiMayBay) {
        List<MayBay> mayBayList = findByLoaiMayBayLike(loaiMayBay);
        return mayBayList;
    }

    @Override
    public MayBay findByLoaiMayBay(String loaiMayBay) {
        return mayBayRepository.findByLoaiMayBay(loaiMayBay);
    }

    @Override
    public Integer countByLoaiMayBayLike(String loaiMaybay) {
        List<MayBay> mayBayList = mayBayRepository.findByLoaiMayBayLike(loaiMaybay);
        return mayBayList.size();
    }

    @Override
    public List<MayBay> findMaybayCanTakeFlightVN280() {
        ChuyenBay chuyenBay = chuyenBayRepo.findByMaCbFake("VN280");
        return mayBayRepository.findByTamBayGreaterThan(chuyenBay.getDoDai());
    }


}
