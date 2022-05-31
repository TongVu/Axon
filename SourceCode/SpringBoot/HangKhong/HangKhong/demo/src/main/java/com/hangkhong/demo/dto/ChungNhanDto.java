package com.hangkhong.demo.dto;

public class ChungNhanDto {
    private Integer nhanVien;
    private Integer mayBay;

    public ChungNhanDto(Integer nhanVien, Integer mayBay) {
        this.nhanVien = nhanVien;
        this.mayBay = mayBay;
    }

    public ChungNhanDto() {
    }

    public Integer getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(Integer nhanVien) {
        this.nhanVien = nhanVien;
    }

    public Integer getMayBay() {
        return mayBay;
    }

    public void setMayBay(Integer mayBay) {
        this.mayBay = mayBay;
    }
}
