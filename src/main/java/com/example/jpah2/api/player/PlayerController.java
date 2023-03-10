package com.example.jpah2.api.player;

import com.example.jpah2.data.player.IPlayerReader;
import com.example.jpah2.data.player.IPlayerWriter;
import com.example.jpah2.data.table.Player;
import com.example.jpah2.data.table.Team;
import com.example.jpah2.data.team.ITeamReader;
import com.example.jpah2.data.team.ITeamWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("player")
public class PlayerController {

    private final IPlayerWriter playerWriter;
    private final IPlayerReader playerReader;
    private final ITeamWriter teamWriter;
    private final ITeamReader teamReader;

    public PlayerController(
            IPlayerWriter playerWriter,
            IPlayerReader playerReader,
            ITeamWriter teamWriter,
            ITeamReader teamReader
    ) {
        this.playerWriter = playerWriter;
        this.playerReader = playerReader;
        this.teamReader = teamReader;
        this.teamWriter = teamWriter;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> get(
            @PathVariable(name = "id") Long id
    ) {
        var player = playerReader.getAll();
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @GetMapping("test")
    public ResponseEntity<Object> test() {
        var t1 = teamWriter.save(Team.of("t1"));
        var p1 = playerWriter.save(Player.of("p1", 10));
        p1.setTeam(t1);
        playerWriter.save(p1);

        var rp1 = playerReader.get(p1.getId());

        return new ResponseEntity<>(rp1, HttpStatus.OK);
    }
}
