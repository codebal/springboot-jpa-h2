package com.example.jpah2.data.team;

import com.example.jpah2.data.dto.GameTeam;
import com.example.jpah2.data.table.Team;

import java.util.List;

public interface ITeamReader {
    Team get(Long id);

    List<Team> getListByGameId(Long gameId);

    List<GameTeam> getGameTeamListByGameId(Long gameId);
}
