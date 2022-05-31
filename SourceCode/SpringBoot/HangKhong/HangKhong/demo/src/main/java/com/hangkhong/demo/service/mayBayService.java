package com.hangkhong.demo.service;

import com.hangkhong.demo.dto.MayBayDto;
import com.hangkhong.demo.entity.MayBay;

import java.util.List;
import java.util.Optional;

public interface mayBayService {
    List<MayBay> getAll();

    Optional<MayBay> getById(Integer id);

    void deleteById(Integer id);

    void save(MayBay mayBay);

    public abstract MayBay toMayBayEntity(MayBayDto mayBayDto);

    public abstract List<MayBay> toMayBayEntity(List<MayBayDto> mayBayDtos);

    public abstract List<MayBayDto> toMayBayDTO(List<MayBay> mayBayList);

    public abstract MayBayDto toMayBayDTO(MayBay mayBay);

    List<MayBay> findByLoaiMayBayLike(String loaiMayBay);

    MayBay findByLoaiMayBay(String loaiMayBay);

    Integer countByLoaiMayBayLike(String loaiMaybay);

    //Cho biết các loại máy bay có thể thực hiện chuyến bay VN280
    List<MayBay> findMaybayCanTakeFlightVN280();
}
