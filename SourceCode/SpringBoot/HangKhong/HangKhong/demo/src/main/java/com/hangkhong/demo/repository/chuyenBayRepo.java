package com.hangkhong.demo.repository;

import com.hangkhong.demo.entity.ChuyenBay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface chuyenBayRepo extends JpaRepository<ChuyenBay,Integer> {
    ChuyenBay findByMaCbFake(String maCbFake);
    List<ChuyenBay> findByGaDen(String gaDen);
    List<ChuyenBay> findByDoDaiBetween(Integer minDoDai, Integer maxDoDai);
    List<ChuyenBay> findByGaDenAndGaDi(String gaDen, String gaDi);
    Integer countByGaDen(String gaDen);
    List<ChuyenBay> findByDoDaiLesserThan(Integer doDai);
    List<ChuyenBay> findByGioDiBefore(LocalDate date);


}
