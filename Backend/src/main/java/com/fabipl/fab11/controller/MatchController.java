package com.fabipl.fab11.controller;
import com.fabipl.fab11.model.MatchModel;
import com.fabipl.fab11.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @GetMapping("/public/match")
    public ResponseEntity<?> getAllMatch(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false)int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false)int pageSize
    ) {
        try {
            return new ResponseEntity<>(matchService.getAllMatches(pageNo, pageSize), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getBody(), e.getStatusCode());
        }
    }

    @GetMapping("/public/match/season")
    public ResponseEntity<?> getMatchBySeason(
            @RequestParam(value = "season", defaultValue = "2008", required = true) Integer season,
            @RequestParam(value = "pageNo", defaultValue = "0", required = false)int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false)int pageSize
    ) {
        try {
            return new ResponseEntity<>(matchService.getMatchBySeason(season, pageNo, pageSize), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getBody(), e.getStatusCode());
        }
    }

    @GetMapping("/public/match/player/{player}")
    public ResponseEntity<?> getMatchByPlayerOfMatch(
            @PathVariable String player,
            @RequestParam(value = "pageNo", defaultValue = "0", required = false)int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false)int pageSize
            ) {
        try {
            return new ResponseEntity<>(matchService.getMatchByPlayerOfMatch(player, pageNo, pageSize), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getBody(), e.getStatusCode());
        }
    }

    @GetMapping("/public/match/team/{team}")
    public ResponseEntity<?> getMatchByTeam(
            @PathVariable String team,
            @RequestParam(value = "pageNo", defaultValue = "0", required = false)int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false)int pageSize
            ) {
        try {
            return new ResponseEntity<>(matchService.getMatchByTeam(team, pageNo, pageSize), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getBody(), e.getStatusCode());
        }
    }

    @GetMapping("/public/match/teams/{team1}/{team2}")
    public ResponseEntity<?> getMatchByTeams(
            @PathVariable String team1,
            @PathVariable String team2,
            @RequestParam(value = "pageNo", defaultValue = "0", required = false)int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false)int pageSize
    ) {
        try {
            return new ResponseEntity<>(matchService.getMatchByTeam1AndTeam2(team1, team2, pageNo, pageSize), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getBody(), e.getStatusCode());
        }
    }

    @GetMapping("/public/match/venue/{venue}")
    public ResponseEntity<?> getMatchByVenue(
            @PathVariable String venue,
            @RequestParam(value = "pageNo", defaultValue = "0", required = false)int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false)int pageSize
    ) {
        try {
            return new ResponseEntity<>(matchService.getMatchByVenue(venue, pageNo, pageSize), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getBody(), e.getStatusCode());
        }
    }

    @GetMapping("/public/match/winner/{winner}")
    public ResponseEntity<?> getMatchByWinner(
            @PathVariable String winner,
            @RequestParam(value = "pageNo", defaultValue = "0", required = false)int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false)int pageSize
    ) {
        try {
            return new ResponseEntity<>(matchService.getMatchByWinner(winner, pageNo, pageSize), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getBody(), e.getStatusCode());
        }
    }

    @GetMapping("/public/match/target")
    public ResponseEntity<?> getMatchByTarget(
            @RequestParam(value = "target", defaultValue = "200", required = true) Integer target,
            @RequestParam(value = "pageNo", defaultValue = "0", required = false)int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false)int pageSize
    ) {
        try {
            return new ResponseEntity<>( matchService.getMatchByTargetRuns(target, pageNo, pageSize), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getBody(), e.getStatusCode());
        }
    }

    @PostMapping("/admin/match")
    public ResponseEntity<String> addMatch(@RequestBody MatchModel match) {
        try {
            return new ResponseEntity<>(matchService.addMatch(match), HttpStatus.CREATED);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    @PutMapping("/admin/match/{id}")
    public ResponseEntity<String> updateMatch(@PathVariable Integer id, @RequestBody MatchModel match) {
        try {
            return new ResponseEntity<>(matchService.updateMatch(id, match), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    @DeleteMapping("/admin/match/{id}")
    public ResponseEntity<String> deleteMatch(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(matchService.deleteMatch(id), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }


}
