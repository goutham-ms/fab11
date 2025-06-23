package com.fabipl.fab11.controller;

import com.fabipl.fab11.model.MatchModel;
import com.fabipl.fab11.service.MatchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/api")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @GetMapping("/public/match")
    public ResponseEntity<List<MatchModel>> getAllMatch() {
        return new ResponseEntity<>(matchService.getAllMatches(), HttpStatus.OK);
    }

    @GetMapping("/public/match/season/{season}")
    public ResponseEntity<List<MatchModel>> getMatchBySeason(@PathVariable Integer season) {
        return new  ResponseEntity(matchService.getMatchBySeason(season), HttpStatus.OK);
    }

    @GetMapping("/public/match/player/{player}")
    public ResponseEntity<List<MatchModel>> getMatchByPlayerOfMatch(@PathVariable String player) {
        return new ResponseEntity<>(matchService.getMatchByPlayerOfMatch(player), HttpStatus.OK);
    }

    @GetMapping("/public/match/team/{team}")
    public ResponseEntity<List<MatchModel>> getMatchByTeam(@PathVariable String team) {
        return new ResponseEntity<>(matchService.getMatchByTeam(team), HttpStatus.OK);
    }

    @GetMapping("/public/match/teams/{team1}/{team2}")
    public ResponseEntity<List<MatchModel>> getMatchByTeams(@PathVariable String team1, @PathVariable String team2) {
        return new ResponseEntity<>(matchService.getMatchByTeam1AndTeam2(team1, team2), HttpStatus.OK);
    }

    @GetMapping("/public/match/venue/{venue}")
    public ResponseEntity<List<MatchModel>> getMatchByVenue(@PathVariable String venue) {
        return new ResponseEntity<>(matchService.getMatchByVenue(venue), HttpStatus.OK);
    }

    @GetMapping("/public/match/winner/{winner}")
    public ResponseEntity<List<MatchModel>> getMatchByWinner(@PathVariable String winner) {
        return new ResponseEntity<>(matchService.getMatchByWinner(winner), HttpStatus.OK);
    }

    @GetMapping("/public/match/target/{target}")
    public ResponseEntity<List<MatchModel>> getMatchByTarget(@PathVariable Integer target) {
        return new ResponseEntity<>( matchService.getMatchByTargetRuns(target), HttpStatus.OK);
    }

    @PostMapping("/public/match")
    public ResponseEntity<String> addMatch(@RequestBody MatchModel match) {
        try {
            return new ResponseEntity<>(matchService.addMatch(match), HttpStatus.CREATED);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    @PutMapping("/public/match/{id}")
    public ResponseEntity<String> updateMatch(@PathVariable Integer id, @RequestBody MatchModel match) {
        try {
            return new ResponseEntity<>(matchService.updateMatch(id, match), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    @DeleteMapping("/public/match/{id}")
    public ResponseEntity<String> deleteMatch(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(matchService.deleteMatch(id), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }


}
