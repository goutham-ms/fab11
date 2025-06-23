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
    public ResponseEntity<?> getAllMatch() {
        try {
            return new ResponseEntity<>(matchService.getAllMatches(), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getBody(), e.getStatusCode());
        }
    }

    @GetMapping("/public/match/season/{season}")
    public ResponseEntity<?> getMatchBySeason(@PathVariable Integer season) {
        try {
            return new ResponseEntity(matchService.getMatchBySeason(season), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getBody(), e.getStatusCode());
        }
    }

    @GetMapping("/public/match/player/{player}")
    public ResponseEntity<?> getMatchByPlayerOfMatch(@PathVariable String player) {
        try {
            return new ResponseEntity<>(matchService.getMatchByPlayerOfMatch(player), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getBody(), e.getStatusCode());
        }
    }

    @GetMapping("/public/match/team/{team}")
    public ResponseEntity<?> getMatchByTeam(@PathVariable String team) {
        try {
            return new ResponseEntity<>(matchService.getMatchByTeam(team), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getBody(), e.getStatusCode());
        }
    }

    @GetMapping("/public/match/teams/{team1}/{team2}")
    public ResponseEntity<?> getMatchByTeams(@PathVariable String team1, @PathVariable String team2) {
        try {
            return new ResponseEntity<>(matchService.getMatchByTeam1AndTeam2(team1, team2), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getBody(), e.getStatusCode());
        }
    }

    @GetMapping("/public/match/venue/{venue}")
    public ResponseEntity<?> getMatchByVenue(@PathVariable String venue) {
        try {
            return new ResponseEntity<>(matchService.getMatchByVenue(venue), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getBody(), e.getStatusCode());
        }
    }

    @GetMapping("/public/match/winner/{winner}")
    public ResponseEntity<?> getMatchByWinner(@PathVariable String winner) {
        try {
            return new ResponseEntity<>(matchService.getMatchByWinner(winner), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getBody(), e.getStatusCode());
        }
    }

    @GetMapping("/public/match/target/{target}")
    public ResponseEntity<?> getMatchByTarget(@PathVariable Integer target) {
        try {
            return new ResponseEntity<>( matchService.getMatchByTargetRuns(target), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getBody(), e.getStatusCode());
        }
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
