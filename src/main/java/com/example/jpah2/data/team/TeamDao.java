package com.example.jpah2.data.team;

import com.example.jpah2.data.dto.GameTeam;
import com.example.jpah2.data.table.QGame;
import com.example.jpah2.data.table.QGameTeam;
import com.example.jpah2.data.table.QTeam;
import com.example.jpah2.data.table.Team;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;

public class TeamDao implements ITeamReader, ITeamWriter {
    private final TeamRepository teamRepository;
    private final JPAQueryFactory jpaQueryFactory;

    public TeamDao(TeamRepository teamRepository, JPAQueryFactory jpaQueryFactory) {
        this.teamRepository = teamRepository;
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Team get(Long id) {
        return teamRepository.getReferenceById(id);
    }

    @Override
    public Team save(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public List<Team> getListByGameId(Long gameId) {
        var list = jpaQueryFactory
            .select(QTeam.team)
            .from(QTeam.team)
            .join(QGameTeam.gameTeam)
            .on(QGameTeam.gameTeam.teamId.eq(QTeam.team.id))
            .where(QGameTeam.gameTeam.gameId.eq(gameId))
            .fetch();
        return list;
    }

    @Override
    public List<GameTeam> getGameTeamListByGameId(Long gameId) {
        var game = QGame.game;
        var team = QTeam.team;
        var gameTeam = QGameTeam.gameTeam;
        var list = jpaQueryFactory.select(
            Projections.constructor(
                GameTeam.class,
                game,
                team
            )
        )
            .from(team)
            .join(gameTeam)
            .on(team.id.eq(gameTeam.teamId))
            .join(game)
            .on(game.id.eq(gameTeam.gameId))
            .where(gameTeam.gameId.eq(gameId))
            .fetch();
        return list;
    }
}
