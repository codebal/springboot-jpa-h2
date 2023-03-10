package com.example.jpah2.data.dto;

import com.example.jpah2.data.table.Game;
import com.example.jpah2.data.table.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GameTeam {
    private Game game;
    private Team team;
}
