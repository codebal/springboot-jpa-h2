package com.example.jpah2.data.player;


import com.example.jpah2.data.table.Player;

public class PlayerWriter implements IPlayerWriter {

    private final PlayerRepository playerRepository;

    public PlayerWriter(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player save(Player player) {
        return playerRepository.save(player);
    }
}
