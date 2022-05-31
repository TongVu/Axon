package com.hangkhong.demo.service.impl;

import com.hangkhong.demo.dto.ChungNhanDto;
import com.hangkhong.demo.entity.ChungNhan;
import com.hangkhong.demo.repository.chungNhanRepo;
import com.hangkhong.demo.service.chungNhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class chungNhanServiceImpl implements chungNhanService {
    @Autowired
    private chungNhanRepo chungNhanRepo;

    @Override
    public List<ChungNhan> getAll() {
        return chungNhanRepo.findAll();
    }

    @Override
    public Optional<ChungNhan> getById(Integer id) {
        return chungNhanRepo.findById(id);
    }

    @Override
    public void save(ChungNhan chungNhan) {
        chungNhanRepo.save(chungNhan);
    }

    @Override
    public void deleteById(Integer id) {
        chungNhanRepo.deleteById(id);
    }

    @Override
    public ChungNhan toChungNhanEntity(ChungNhanDto chungNhanDto) {
        return new ChungNhan(chungNhanDto.getNhanVien(),chungNhanDto.getMayBay());
    }

    @Override
    public List<ChungNhan> toChungNhanEntity(List<ChungNhanDto> chungNhanDtos) {
        List<ChungNhan>chungEntityList=new ArrayList<>();
        for (ChungNhanDto chungNhan:chungNhanDtos
             ) {
            chungEntityList.add(new ChungNhan(chungNhan.getNhanVien(),chungNhan.getMayBay()));
        }
        return chungEntityList;
    }
    @Override
    public List<ChungNhanDto> toChungNhanDTO(List<ChungNhan> chungNhans) {
        List<ChungNhanDto>chungNhanDtos=new ArrayList<>();
        for (ChungNhan chungNhan:chungNhans
        ) {
            chungNhanDtos.add(new ChungNhanDto(chungNhan.getNhanVien().getManv(),chungNhan.getMaybay().getMamb()));
        }
        return chungNhanDtos;
    }

    @Override
    public ChungNhanDto toChungNhanDTO(ChungNhan chungNhan) {
        return new ChungNhanDto(chungNhan.getNhanVien().getManv(),chungNhan.getMaybay().getMamb());
    }

//    @Override
//    public ChungNhan findByMayBayMamb(Integer loaiMayBay) {
//        ChungNhan chungNhanList = findByMayBayMamb(loaiMayBay);
//        return chungNhanList;
//    }
}
