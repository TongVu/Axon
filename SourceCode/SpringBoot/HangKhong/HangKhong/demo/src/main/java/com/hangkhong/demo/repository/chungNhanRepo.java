package com.hangkhong.demo.repository;

import com.hangkhong.demo.entity.ChungNhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface chungNhanRepo extends JpaRepository<ChungNhan,Integer> {

//    ChungNhan findByMayBayMamb(Integer loaiMayBay);

}
