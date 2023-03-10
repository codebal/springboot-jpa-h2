package com.example.jpah2.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Team {
    private Long id;
    private String name;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;
}
