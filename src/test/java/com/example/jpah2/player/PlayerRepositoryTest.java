package com.example.jpah2.player;

import com.example.jpah2.TestConfig;
import com.example.jpah2.data.player.IPlayerReader;
import com.example.jpah2.data.player.IPlayerWriter;
import com.example.jpah2.data.table.Player;
import com.example.jpah2.data.table.Team;
import com.example.jpah2.data.team.ITeamReader;
import com.example.jpah2.data.team.ITeamWriter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(TestConfig.class)
@ActiveProfiles("test")
public class PlayerRepositoryTest {
    private final IPlayerWriter playerWriter;
    private final IPlayerReader playerReader;
    private final ITeamWriter teamWriter;
    private final ITeamReader teamReader;

    @Autowired
    public PlayerRepositoryTest(
            IPlayerWriter playerWriter,
            IPlayerReader playerReader,
            ITeamWriter teamWriter,
            ITeamReader teamReader
    ) {
        this.playerWriter = playerWriter;
        this.playerReader = playerReader;
        this.teamWriter = teamWriter;
        this.teamReader = teamReader;
    }

    @Test
    void sut_get_player() {
        assertThat(1)
                .isNotNull();
    }

    @Test
    void sut_player_save() throws InterruptedException {
        var player = Player.of(
                "player1",
                10
        );
        var result = playerWriter.save(player);
        assertThat(result)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(player);
    }

    @Test
    void sut_player_join_team() {
        var team = teamWriter.save(Team.of("team1"));
        var p1 = playerWriter.save(Player.of("player1", 10));
        var p2 = playerWriter.save(Player.of("player2", 20));
        var p3 = playerWriter.save(Player.of("player3", 30));

        p1.setTeam(team);
        p2.setTeam(team);
        p3.setTeam(team);

        playerWriter.save(p1);
        playerWriter.save(p2);
        playerWriter.save(p3);

//        team.setPlayerList(Lists.list(p1, p2, p3));
//        teamWriter.save(team);

        var t1 = teamReader.get(team.getId());

        assertThat(t1)
                .isNotNull();

        var getP3 = playerReader.get(p3.getId());
        assertThat(getP3)
                .isNotNull();

    }

}
