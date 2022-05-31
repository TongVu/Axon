package com.hangkhong.demo.service;

import com.hangkhong.demo.dto.ChungNhanDto;
import com.hangkhong.demo.entity.ChungNhan;

import java.util.List;
import java.util.Optional;

public interface chungNhanService {
    List<ChungNhan> getAll();

    Optional<ChungNhan> getById(Integer id);

    void save(ChungNhan chungNhan);

    void deleteById(Integer id);

    public abstract ChungNhan toChungNhanEntity(ChungNhanDto chungNhanDto);

    List<ChungNhan> toChungNhanEntity(List<ChungNhanDto> chungNhanDtos);

    List<ChungNhanDto> toChungNhanDTO(List<ChungNhan> chungNhans);

    ChungNhanDto toChungNhanDTO(ChungNhan chungNhan);

//    ChungNhan findByMayBayMamb(Integer loaiMayBay);


}
