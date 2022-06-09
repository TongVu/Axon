package com.example.demo.service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
//If I have so many different Dtos with different fields
public class MatchDto {
        private Integer id;
        private LocalDate startDate;
        private Integer duration;
        private String player1Name;
        private String player2Name;
        private String roundName;
        private String stadiumName;
}
