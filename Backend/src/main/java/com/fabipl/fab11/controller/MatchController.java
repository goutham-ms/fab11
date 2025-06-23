package com.fabipl.fab11.controller;

import com.fabipl.fab11.model.MatchModel;
import com.fabipl.fab11.service.MatchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @GetMapping("/public/match")
    public List<MatchModel> getAllMatch() {
        return matchService.getAllMatches();
    }

    @GetMapping("/public/match/season/{season}")
    public List<MatchModel> getMatchBySeason(@PathVariable Integer season) {
        return matchService.getMatchBySeason(season);
    }

    @GetMapping("/public/match/player/{player}")
    public List<MatchModel> getMatchByPlayerOfMatch(@PathVariable String player) {
        return matchService.getMatchByPlayerOfMatch(player);
    }

    @GetMapping("/public/match/team/{team}")
    public List<MatchModel> getMatchByTeam(@PathVariable String team) {
        return matchService.getMatchByTeam(team);
    }

    @GetMapping("/public/match/teams/{team1}/{team2}")
    public List<MatchModel> getMatchByTeams(@PathVariable String team1, @PathVariable String team2) {
        return matchService.getMatchByTeam1AndTeam2(team1, team2);
    }

    @GetMapping("/public/match/venue/{venue}")
    public List<MatchModel> getMatchByVenue(@PathVariable String venue) {
        return matchService.getMatchByVenue(venue);
    }

    @GetMapping("/public/match/winner/{winner}")
    public List<MatchModel> getMatchByWinner(@PathVariable String winner) {
        return matchService.getMatchByWinner(winner);
    }

    @GetMapping("/public/match/target/{target}")
    public List<MatchModel> getMatchByTarget(@PathVariable Integer target) {
        return matchService.getMatchByTargetRuns(target);
    }

    @PostMapping("/public/match")
    public String addMatch(@RequestBody MatchModel match) {
        return matchService.addMatch(match);
    }

    @PutMapping("/public/match/{id}")
    public String updateMatch(@PathVariable Integer id, @RequestBody MatchModel match) {
        return matchService.updateMatch(id, match);
    }

    @DeleteMapping("/public/match/{id}")
    public String deleteMatch(@PathVariable Integer id) {
        return matchService.deleteMatch(id);
    }


}
