package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Set {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Integer playerOneScore;

    @NotNull
    private Integer playerTwoScore;

    private Integer setWinnderid;

    private Integer setNumber;

    private LocalDate startTime;

    private LocalDate endTime;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;
}
