package com.example.jpah2.data.gameTeam;

import com.example.jpah2.data.table.GameTeam;

public class GameTeamWriter implements IGameTeamWriter {

    private final GameTeamRepository gameTeamRepository;

    public GameTeamWriter(GameTeamRepository gameTeamRepository) {
        this.gameTeamRepository = gameTeamRepository;
    }

    @Override
    public GameTeam save(GameTeam gameTeam) {
        return gameTeamRepository.save(gameTeam);
    }
}
