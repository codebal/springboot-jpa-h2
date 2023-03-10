package com.example.jpah2.data.player;

import com.example.jpah2.data.table.Player;

import java.util.List;

public interface IPlayerReader {
    Player get(Long id);

    List<Player> getAll();
}
