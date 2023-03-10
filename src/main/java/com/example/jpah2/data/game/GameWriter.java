package com.example.jpah2.data.game;

import com.example.jpah2.data.table.Game;
import com.example.jpah2.data.table.QGame;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class GameWriter implements IGameWriter{
    private final GameRepository gameRepository;

    private final JPAQueryFactory jpaQueryFactory;

    public GameWriter(GameRepository gameRepository, JPAQueryFactory jpaQueryFactory) {
        this.gameRepository = gameRepository;
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Game save(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Long saveDsl(Game game) {
        return jpaQueryFactory.insert(QGame.game)
                .columns(QGame.game.name)
                .values(game.getName())
                .execute();
    }
}
