package com.hangkhong.demo.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer manv;

    @Column(nullable = false,length =100)
    private String name;

    private  Integer salary;

}
