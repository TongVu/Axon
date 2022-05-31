package com.hangkhong.demo.service;


import com.hangkhong.demo.dto.NhanVienDto;
import com.hangkhong.demo.entity.NhanVien;

import java.util.List;
import java.util.Optional;

public interface nhanVienService {
    List<NhanVien> getAllNhanVien();

    Optional<NhanVien> findNhanVienById(Integer id);

    void save(NhanVien nhanVien);

    void deleteNhanVienById(Integer id);

    public abstract NhanVien toNhanVienEntity(NhanVienDto nhanVienDto);

    public abstract List<NhanVien> toManyNhanVienEntity(List<NhanVienDto> nhanVienDtos);

    public abstract List<NhanVienDto> toNhanVienDTO(List<NhanVien> nhanViens);

    public abstract NhanVienDto toNhanVienDTO(NhanVien nhanVien);

    Integer salaryAll();
}
