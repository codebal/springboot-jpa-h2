package com.example.jpah2;

import com.example.jpah2.data.game.*;
import com.example.jpah2.data.gameTeam.GameTeamRepository;
import com.example.jpah2.data.gameTeam.GameTeamWriter;
import com.example.jpah2.data.gameTeam.IGameTeamWriter;
import com.example.jpah2.data.player.*;
import com.example.jpah2.data.team.ITeamReader;
import com.example.jpah2.data.team.ITeamWriter;
import com.example.jpah2.data.team.TeamDao;
import com.example.jpah2.data.team.TeamRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfig {

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }

    @Bean
    public IPlayerWriter playerWriter(
            PlayerRepository playerRepository
    ) {
        return new PlayerWriter(playerRepository);
    }

    @Bean
    public IPlayerReader playerReader(
            PlayerRepository playerRepository
    ) {
        return new PlayerReader(playerRepository);
    }

    @Bean
    public ITeamWriter teamWriter(
            TeamRepository teamRepository,
            JPAQueryFactory jpaQueryFactory
    ) {
        return new TeamDao(
                teamRepository,
                jpaQueryFactory
        );
    }

    @Bean
    public ITeamReader teamReader(
            TeamRepository teamRepository,
            JPAQueryFactory jpaQueryFactory
    ) {
        return new TeamDao(
                teamRepository,
                jpaQueryFactory
        );
    }

    @Bean
    public IGameWriter gameWriter(
            GameRepository gameRepository,
            JPAQueryFactory jpaQueryFactory
    ) {
        return new GameWriter(
                gameRepository,
                jpaQueryFactory
        );
    }

    @Bean
    public IGameReader gameReader(
            GameRepository gameRepository
    ) {
        return new GameReader(gameRepository);
    }

    @Bean
    public IGameTeamWriter gameTeamWriter(
            GameTeamRepository gameTeamRepository
    ) {
        return new GameTeamWriter(gameTeamRepository);
    }

}
