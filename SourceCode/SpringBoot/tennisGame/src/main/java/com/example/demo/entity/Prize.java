package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Prize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String prizeType;

    @NotNull
    private String prizeAmount;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;
}
