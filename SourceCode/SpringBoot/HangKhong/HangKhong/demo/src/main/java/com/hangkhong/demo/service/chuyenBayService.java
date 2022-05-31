package com.hangkhong.demo.service;

import com.hangkhong.demo.dto.ChuyenBayDto;
import com.hangkhong.demo.entity.ChuyenBay;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface chuyenBayService {
    List<ChuyenBay> getAll();

    Optional<ChuyenBay> getById(Integer id);

    void save(ChuyenBay chuyenBay);

    void deleteById(Integer id);

    public abstract ChuyenBay toChuyenBayEntity(ChuyenBayDto chuyenBayDto);

    public abstract List<ChuyenBay> toChuyenBayEntity(List<ChuyenBayDto> chuyenBayDtos);

    public abstract List<ChuyenBayDto> toChuyenBayDTO(List<ChuyenBay> chuyenBayList);

    public abstract ChuyenBayDto toChuyenBayDTO(ChuyenBay chuyenBay);


    Integer countByGaDen(String gaDen);
    ChuyenBay findByMaCbFake(String maCbFake);
    List<ChuyenBay> findByDoDaiLesserThan(Integer doDai);

//14.	Cho biết các chuyến bay có thể ñược thực hiện bởi máy bay Airbus A320.
    List<ChuyenBay> findChuyenBayFlighttableByA320();
//20.	Cho biết danh sách các chuyến bay có thể khởi hành trước 12:00
    List<ChuyenBay> findByGioDiBefore(LocalDate date);


}
