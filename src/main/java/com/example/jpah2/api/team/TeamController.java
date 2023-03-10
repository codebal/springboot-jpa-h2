package com.example.jpah2.api.team;

import com.example.jpah2.data.team.ITeamReader;
import com.example.jpah2.data.team.TeamDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("team")
public class TeamController {

    private final ITeamReader teamReader;

    public TeamController(ITeamReader teamReader) {
        this.teamReader = teamReader;
    }

    @GetMapping("test")
    public ResponseEntity<Object> test() {
        var list = teamReader.getListByGameId(1L);
        return new ResponseEntity(list, HttpStatus.OK);
    }

}
