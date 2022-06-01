package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate startDate;

    private Integer duration;

    private Integer winnerID;

    @NotNull
    @Column(unique = true)
    private Player playerOne;

    @NotNull
    @Column(unique = true)
    private Player playerTwo;

    @ManyToOne
    @JoinColumn(name = "round_id")
    private Round round;

    @ManyToOne
    @JoinColumn(name = "stadium_id")
    private Stadium stadium;

    @ManyToOne
    @JoinColumn(name = "player1_id", unique = true)
    private Player player1;

    @ManyToOne
    @JoinColumn(name = "player2_id", unique = true)
    private Player player2;
}
