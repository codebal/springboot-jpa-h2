package com.example.jpah2.data.player;

import com.example.jpah2.data.table.Player;

import java.util.List;

public class PlayerReader implements IPlayerReader {

    private final PlayerRepository playerRepository;

    public PlayerReader(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player get(Long id) {
        return playerRepository.getReferenceById(id);
    }

    @Override
    public List<Player> getAll() {
        return playerRepository.findAll();
    }
}
