package com.example.jpah2.data.game;

import com.example.jpah2.data.table.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
