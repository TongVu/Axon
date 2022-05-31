package com.hangkhong.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class ChuyenBay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 5)
    private Integer maCb;

    @Column(unique = true)
    private String maCbFake;


    @Column(length = 60)
    @NotNull
    private String gaDi;

    @Column(length = 60)
    @NotNull
    private String gaDen;

    private Integer doDai;

    private LocalDate gioDi;

    private LocalDate gioDen;

    @NotNull
    private Integer chiPhi;
}
