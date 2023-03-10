package com.example.jpah2.data.game;

import com.example.jpah2.data.table.Game;

public interface IGameWriter {
    Game save(Game game);

    Long saveDsl(Game game);
}
