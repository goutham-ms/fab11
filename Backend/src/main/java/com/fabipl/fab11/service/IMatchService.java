package com.fabipl.fab11.service;

import com.fabipl.fab11.model.MatchModel;
import com.fabipl.fab11.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public String addMatch(MatchModel match) {
        Optional<MatchModel> existingMatch = matchRepository.findByTeam1AndTeam2(match.getTeam1(), match.getTeam2())
                .stream().filter(c -> c.getDate().equals(match.getDate()) || c.getVenue().equals(match.getVenue()) || c.getCity().equals(match.getCity()))
                .findAny();
        if(existingMatch.isPresent()) {
            return "Match already exits";
        } else {
            matchRepository.save(match);
            return "Match saved";
        }

    }

    @Override
    public String updateMatch(Integer id, MatchModel match) {
        Optional<MatchModel> optionalMatch = matchRepository.findById(id)
                .stream().findAny();
        if(optionalMatch.isPresent()) {
            MatchModel existingMatch = optionalMatch.get();
            existingMatch.setId(match.getId());
            existingMatch.setSeason(match.getSeason());
            existingMatch.setCity(match.getCity());
            existingMatch.setDate(match.getDate());
            existingMatch.setPlayerOfMatch(match.getPlayerOfMatch());
            existingMatch.setVenue(match.getVenue());
            existingMatch.setTeam1(match.getTeam1());
            existingMatch.setTeam2(match.getTeam2());
            existingMatch.setTossWinner(match.getTossWinner());
            existingMatch.setTossDecision(match.getTossDecision());
            existingMatch.setWinner(match.getWinner());
            existingMatch.setResult(match.getResult());
            existingMatch.setResultMargin(match.getResultMargin());
            existingMatch.setTargetRuns(match.getTargetRuns());
            matchRepository.save(existingMatch);
            return "Match updated successfully";
        } else {
            return "Match not found";
        }
    }


    @Override
    public String deleteMatch(Integer id) {
        Optional<MatchModel> optionalMatch = matchRepository.findById(id).stream()
                .findAny();
        if(optionalMatch.isPresent()) {
            MatchModel match = optionalMatch.get();
            matchRepository.delete(match);
            return "Match Deleted";
        } else {
            return "Match not found";
        }
    }
}
