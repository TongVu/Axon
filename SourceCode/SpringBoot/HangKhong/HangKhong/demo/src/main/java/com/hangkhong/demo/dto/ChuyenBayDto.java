package com.hangkhong.demo.dto;

import java.time.LocalDate;

public class ChuyenBayDto {
    private Integer maCb;
    private String gaDi;
    private String gaDen;
    private LocalDate gioDi;
    private LocalDate gioDen;

    public ChuyenBayDto(Integer maCb, String gaDi, String gaDen, LocalDate gioDi, LocalDate gioDen) {
        this.maCb = maCb;
        this.gaDi = gaDi;
        this.gaDen = gaDen;
        this.gioDi = gioDi;
        this.gioDen = gioDen;
    }

    public ChuyenBayDto() {
    }

    public ChuyenBayDto(Integer maCb, String gaDi, String gaDen) {
        this.maCb = maCb;
        this.gaDi = gaDi;
        this.gaDen = gaDen;
    }

    public Integer getMaCb() {
        return maCb;
    }

    public void setMaCb(Integer maCb) {
        this.maCb = maCb;
    }

    public String getGaDi() {
        return gaDi;
    }

    public void setGaDi(String gaDi) {
        this.gaDi = gaDi;
    }

    public String getGaDen() {
        return gaDen;
    }

    public void setGaDen(String gaDen) {
        this.gaDen = gaDen;
    }

    public LocalDate getGioDi() {
        return gioDi;
    }

    public void setGioDi(LocalDate gioDi) {
        this.gioDi = gioDi;
    }

    public LocalDate getGioDen() {
        return gioDen;
    }

    public void setGioDen(LocalDate gioDen) {
        this.gioDen = gioDen;
    }
}
