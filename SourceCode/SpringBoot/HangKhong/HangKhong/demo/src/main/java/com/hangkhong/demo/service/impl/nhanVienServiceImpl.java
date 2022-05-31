package com.hangkhong.demo.service.impl;

import com.hangkhong.demo.dto.NhanVienDto;
import com.hangkhong.demo.entity.NhanVien;
import com.hangkhong.demo.repository.nhanVienRepo;
import com.hangkhong.demo.service.nhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class nhanVienServiceImpl implements nhanVienService {

    @Autowired
    private nhanVienRepo nhanVienRepository;

    @Override
    public List<NhanVien> getAllNhanVien() {
        return nhanVienRepository.findAll();
    }

    @Override
    public Optional<NhanVien> findNhanVienById(Integer id) {
        return nhanVienRepository.findById(id);
    }

    @Override
    public void save(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    @Override
    public void deleteNhanVienById(Integer id) {
        nhanVienRepository.deleteById(id);
    }

    @Override
    public NhanVien toNhanVienEntity(NhanVienDto nhanVienDto) {
        return new NhanVien(
                nhanVienDto.getManv(),
                nhanVienDto.getName());
    }

    @Override
    public List<NhanVien> toManyNhanVienEntity(List<NhanVienDto> nhanVienDtos) {
        List<NhanVien> nhanVienList = new ArrayList<>();
        for (NhanVienDto nhanVienDTO : nhanVienDtos
        ) {
            nhanVienList.add(new NhanVien(nhanVienDTO.getManv(), nhanVienDTO.getName()));
        }
        return nhanVienList;
    }

    @Override
    public List<NhanVienDto> toNhanVienDTO(List<NhanVien> nhanViens) {
        List<NhanVienDto> nhanVienDtoList = new ArrayList<>();
        for (NhanVien nhanVien : nhanViens) {
            nhanVienDtoList.add(new NhanVienDto(nhanVien.getManv(), nhanVien.getName()));
        }
        return nhanVienDtoList;
    }

    @Override
    public NhanVienDto toNhanVienDTO(NhanVien nhanVien) {
        return new NhanVienDto(nhanVien.getManv(), nhanVien.getName());
    }

    @Override
    public Integer salaryAll() {
        List<NhanVien> nhanVienList = new ArrayList<>();
        nhanVienList = nhanVienRepository.findAll();
        Integer sum = 0;
        for(NhanVien nhanVien: nhanVienList)
            sum += nhanVien.getSalary();
        return sum;
    }


}
