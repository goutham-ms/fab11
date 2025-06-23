package com.fabipl.fab11.service;

import com.fabipl.fab11.model.MatchModel;
import com.fabipl.fab11.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;

@Service
public class IMatchService implements MatchService {
    @Autowired
    private MatchRepository matchRepository;

    @Override
    public List<MatchModel> getAllMatches() {
        List<MatchModel> matches = matchRepository.findAll();
        if(matches.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Match not found!");
        }
        return matches;
    }
    @Override
    public List<MatchModel> getMatchBySeason(Integer season) {
        List<MatchModel> matches = matchRepository.findBySeason(season);
        if(matches.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Match not found!");
        }
        return matches;
    }

    @Override
    public List<MatchModel> getMatchByPlayerOfMatch(String playerOfMatch) {
        List<MatchModel> matches = matchRepository.findByPlayerOfMatch(playerOfMatch);
        if(matches.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Match not found!");
        }
        return matches;
    }

    @Override
    public List<MatchModel> getMatchByTeam(String team) {
        List<MatchModel> matches = matchRepository.findByTeam(team);
        if(matches.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Match not found!");
        }
        return matches;
    }

    @Override
    public List<MatchModel> getMatchByTeam1AndTeam2(String team1, String team2) {
        List<MatchModel> matches = matchRepository.findByTeam1AndTeam2(team1, team2);
        if(matches.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Match not found!");
        }
        return matches;
    }

    @Override
    public List<MatchModel> getMatchByVenue(String venue) {
        List<MatchModel> matches = matchRepository.findByVenueContainingIgnoreCase(venue);
        if(matches.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Match not found!");
        }
        return matches;
    }

    @Override
    public List<MatchModel> getMatchByWinner(String winner) {
        List<MatchModel> matches = matchRepository.findByWinnerContainingIgnoreCase(winner);
        if(matches.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Match not found!");
        }
        return matches;
    }

    @Override
    public List<MatchModel> getMatchByTargetRuns(Integer targetRuns) {
        List<MatchModel> matches = matchRepository.findByTargetRunsGreaterThan(targetRuns);
        if(matches.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Match not found!");
        }
        return matches;
    }

    @Override
    public String addMatch(MatchModel match) {

        Optional<MatchModel> optionalMatch = matchRepository.findDuplicateMatch(match.getDate(), match.getVenue(), match.getCity());

        if(optionalMatch.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Match already exits");
        } else {
            matchRepository.save(match);
            return "Match saved";
        }
    }

    @Override
    public String updateMatch(Integer id, MatchModel match) {
        MatchModel existingMatch = matchRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Match not found!"));

        existingMatch.setId(id);
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
    }


    @Override
    public String deleteMatch(Integer id) {

        MatchModel existingMatch = matchRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Match not found!"));

        matchRepository.delete(existingMatch);
        return "Match deleted successfully";
    }



}
