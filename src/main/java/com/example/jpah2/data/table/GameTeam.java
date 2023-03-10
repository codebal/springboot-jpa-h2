package com.example.jpah2.data.table;

import jakarta.persistence.*;

@Entity
@Table(name = "game_team")
public class GameTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long gameId;

    private Long teamId;

    public static GameTeam of(Long gameId, Long teamId) {
        var gameTeam = new GameTeam();
        gameTeam.gameId = gameId;
        gameTeam.teamId = teamId;
        return gameTeam;
    }

}
