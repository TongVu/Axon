package com.hangkhong.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class MayBay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mamb;

    @Column(length = 60)
    private String loaiMayBay;

    private Integer tamBay;
}
