package com.fabipl.fab11.service;

import com.fabipl.fab11.model.MatchModel;
import com.fabipl.fab11.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IMatchService implements MatchService {
    @Autowired
    private MatchRepository matchRepository;

    @Override
    public List<MatchModel> getAllMatches() {
        return matchRepository.findAll();
    }
    @Override
    public List<MatchModel> getMatchBySeason(Integer season) {
        return matchRepository.findBySeason(season);
    }

    @Override
    public List<MatchModel> getMatchByPlayerOfMatch(String playerOfMatch) {
        return matchRepository.findByPlayerOfMatch(playerOfMatch);
    }

    @Override
    public List<MatchModel> getMatchByTeam(String team) {
        return matchRepository.findByTeam1(team);
    }

    @Override
    public List<MatchModel> getMatchByTeam1AndTeam2(String team1, String team2) {
        return matchRepository.findByTeam1AndTeam2(team1, team2);
    }

    @Override
    public List<MatchModel> getMatchByVenue(String venue) {
        return matchRepository.findByVenue(venue);
    }

    @Override
    public List<MatchModel> getMatchByWinner(String winner) {
        return matchRepository.findByWinner(winner);
    }

    @Override
    public List<MatchModel> getMatchByTargetRuns(Integer targetRuns) {
      return matchRepository.findByTargetRuns(targetRuns);
    }

    @Override
    public List<MatchModel> updateMatch(Integer id) {
        return List.of();
    }

    @Override
    public List<String> deleteMatch(Integer id) {
        return List.of();
    }

}
