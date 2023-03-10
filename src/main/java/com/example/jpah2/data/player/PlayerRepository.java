package com.example.jpah2.data.player;

import com.example.jpah2.data.table.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
