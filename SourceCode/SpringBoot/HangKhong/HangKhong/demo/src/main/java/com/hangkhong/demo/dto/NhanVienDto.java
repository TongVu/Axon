package com.hangkhong.demo.dto;

public class NhanVienDto {
    private Integer manv;
    private String name;

    public NhanVienDto(Integer manv, String name) {
        this.manv = manv;
        this.name = name;
    }

    public NhanVienDto() {
    }

    public Integer getManv() {
        return manv;
    }

    public void setManv(Integer manv) {
        this.manv = manv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
