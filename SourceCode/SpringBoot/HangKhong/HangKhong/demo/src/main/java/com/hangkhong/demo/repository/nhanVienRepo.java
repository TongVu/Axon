package com.hangkhong.demo.repository;

import com.hangkhong.demo.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface nhanVienRepo extends JpaRepository<NhanVien, Integer> {
    List<NhanVien> findBySalaryGreaterThan(Integer salary);

}
