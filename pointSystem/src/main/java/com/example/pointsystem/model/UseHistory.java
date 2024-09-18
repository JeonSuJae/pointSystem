package com.example.pointsystem.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor @Getter @Setter @ToString
public class UseHistory {
    private Integer historyNum;
    private Integer orderNum;
    private Integer point;
    private Integer pointKey;
}
