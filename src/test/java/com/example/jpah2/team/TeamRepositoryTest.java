package com.example.jpah2.team;

import com.example.jpah2.TestConfig;
import com.example.jpah2.data.game.IGameWriter;
import com.example.jpah2.data.gameTeam.IGameTeamWriter;
import com.example.jpah2.data.table.Game;
import com.example.jpah2.data.table.GameTeam;
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
public class TeamRepositoryTest {

    private final ITeamWriter teamWriter;
    private final ITeamReader teamReader;
    private final IGameWriter gameWriter;
    private final IGameTeamWriter gameTeamWriter;

    @Autowired
    public TeamRepositoryTest(
            ITeamWriter teamWriter,
            ITeamReader teamReader,
            IGameWriter gameWriter,
            IGameTeamWriter gameTeamWriter
            ) {
        this.teamWriter = teamWriter;
        this.teamReader = teamReader;
        this.gameWriter = gameWriter;
        this.gameTeamWriter = gameTeamWriter;
    }

    @Test
    void sut_team_join() {
        var g1 = gameWriter.save(Game.of("game1"));
        var t1 = teamWriter.save(Team.of("team1"));
        var t2 = teamWriter.save(Team.of("team2"));
        var t3 = teamWriter.save(Team.of("team3"));
        gameTeamWriter.save(GameTeam.of(g1.getId(), t1.getId()));
        gameTeamWriter.save(GameTeam.of(g1.getId(), t2.getId()));
        gameTeamWriter.save(GameTeam.of(g1.getId(), t3.getId()));
        var list = teamReader.getListByGameId(g1.getId());

        assertThat(list)
                .hasSize(3);

    }

    @Test
    void sut_team_game_join() {
        var g1 = gameWriter.save(Game.of("game1"));
        var t1 = teamWriter.save(Team.of("team1"));
        var t2 = teamWriter.save(Team.of("team2"));
        var t3 = teamWriter.save(Team.of("team3"));
        gameTeamWriter.save(GameTeam.of(g1.getId(), t1.getId()));
        gameTeamWriter.save(GameTeam.of(g1.getId(), t2.getId()));
        gameTeamWriter.save(GameTeam.of(g1.getId(), t3.getId()));

        var list = teamReader.getGameTeamListByGameId(g1.getId());

        assertThat(list)
            .hasSize(3);
        assertThat(list.get(0))
            .isInstanceOf(com.example.jpah2.data.dto.GameTeam.class);
    }
}
