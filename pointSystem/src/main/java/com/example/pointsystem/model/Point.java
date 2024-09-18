package com.example.pointsystem.model;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor @Getter @Setter @ToString
public class Point {
    private Integer pointKey;
    private Integer point;
    private String manual;
    private LocalDate endDate;
    private String useYn;
    private Integer userKey;
}
