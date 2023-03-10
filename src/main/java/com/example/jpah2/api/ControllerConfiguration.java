package com.example.jpah2.api;

import com.example.jpah2.data.player.*;
import com.example.jpah2.data.team.ITeamReader;
import com.example.jpah2.data.team.ITeamWriter;
import com.example.jpah2.data.team.TeamDao;
import com.example.jpah2.data.team.TeamRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfiguration {

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

}
