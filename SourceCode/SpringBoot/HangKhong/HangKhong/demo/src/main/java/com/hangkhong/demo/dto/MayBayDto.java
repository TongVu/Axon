package com.hangkhong.demo.dto;

public class MayBayDto {
    private  Integer mamb;
    private String loaiMayBay;
    private Integer tamBay;

    public MayBayDto(Integer mamb, String loaiMayBay, Integer tamBay) {
        this.mamb = mamb;
        this.loaiMayBay = loaiMayBay;
        this.tamBay = tamBay;
    }

    public MayBayDto() {
    }

    public Integer getMamb() {
        return mamb;
    }

    public void setMamb(Integer mamb) {
        this.mamb = mamb;
    }

    public String getLoaiMayBay() {
        return loaiMayBay;
    }

    public void setLoaiMayBay(String loaiMayBay) {
        this.loaiMayBay = loaiMayBay;
    }

    public Integer getTamBay() {
        return tamBay;
    }

    public void setTamBay(Integer tamBay) {
        this.tamBay = tamBay;
    }
}
