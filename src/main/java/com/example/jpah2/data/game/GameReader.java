package com.example.jpah2.data.game;

import com.example.jpah2.data.table.Game;

public class GameReader implements IGameReader {

    private final GameRepository gameRepository;

    public GameReader(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game get(Long id) {
        return gameRepository.getReferenceById(id);
    }
}
