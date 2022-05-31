package com.hangkhong.demo.repository;

import com.hangkhong.demo.entity.MayBay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface mayBayRepo extends JpaRepository<MayBay,Integer> {

    List<MayBay> findByTamBayGreaterThan(Integer tamBay);
    List<MayBay> findByLoaiMayBayLike(String loaiMayBay);
    MayBay findByLoaiMayBay(String loaiMayBay);
    Integer countByLoaiMayBayLike(String loaiMaybay);
}
