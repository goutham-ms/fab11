package com.fabipl.fab11.service;

import com.fabipl.fab11.dto.MatchResponse;
import com.fabipl.fab11.model.MatchModel;
import com.fabipl.fab11.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public MatchResponse getAllMatches(int pageNo, int pageSize) {
        Pageable pageable =  PageRequest.of(pageNo , pageSize);
        Page<MatchModel> pagedMatches = matchRepository.findAll(pageable);
        List<MatchModel> matches = pagedMatches.getContent();
        if(matches.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Match not found!");
        } else {
            MatchResponse matchResponse = new MatchResponse();
            matchResponse.setContent(matches);
            matchResponse.setPageNo(pagedMatches.getNumber());
            matchResponse.setPageSize(pagedMatches.getSize());
            matchResponse.setTotalItems(pagedMatches.getTotalElements());
            matchResponse.setTotalPages(pagedMatches.getTotalPages());
            matchResponse.setLast(pagedMatches.isLast());
            return matchResponse;
        }
    }
    @Override
    public MatchResponse getMatchBySeason(Integer season, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<MatchModel> pagedMatches = matchRepository.findBySeason(season, pageable);
        List<MatchModel> matches = pagedMatches.getContent();
        if(matches.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Match not found!");
        } else {
            MatchResponse matchResponse = new MatchResponse();
            matchResponse.setContent(matches);
            matchResponse.setPageNo(pagedMatches.getNumber());
            matchResponse.setPageSize(pagedMatches.getSize());
            matchResponse.setTotalItems(pagedMatches.getTotalElements());
            matchResponse.setTotalPages(pagedMatches.getTotalPages());
            matchResponse.setLast(pagedMatches.isLast());
          return matchResponse;
        }
    }

    @Override
    public MatchResponse getMatchByPlayerOfMatch(String playerOfMatch, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<MatchModel> pagedMatches = matchRepository.findByPlayerOfMatch(playerOfMatch, pageable);
        List<MatchModel> matches = pagedMatches.getContent();
        if(matches.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Match not found!");
        } else  {
            MatchResponse matchResponse = new MatchResponse();
            matchResponse.setContent(matches);
            matchResponse.setPageNo(pagedMatches.getNumber());
            matchResponse.setPageSize(pagedMatches.getSize());
            matchResponse.setTotalItems(pagedMatches.getTotalElements());
            matchResponse.setTotalPages(pagedMatches.getTotalPages());
            matchResponse.setLast(pagedMatches.isLast());
            return matchResponse;
        }
    }

    @Override
    public MatchResponse getMatchByTeam(String team, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<MatchModel> pagedMatches = matchRepository.findByTeam(team, pageable);
        List<MatchModel> matches = pagedMatches.getContent();
        if(matches.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Match not found!");
        } else {
            MatchResponse matchResponse = new MatchResponse();
            matchResponse.setContent(matches);
            matchResponse.setPageNo(pagedMatches.getNumber());
            matchResponse.setPageSize(pagedMatches.getSize());
            matchResponse.setTotalItems(pagedMatches.getTotalElements());
            matchResponse.setTotalPages(pagedMatches.getTotalPages());
            matchResponse.setLast(pagedMatches.isLast());
            return matchResponse;
        }
    }

    @Override
    public MatchResponse getMatchByTeam1AndTeam2(String team1, String team2, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<MatchModel> pagedMatches = matchRepository.findByTeam1AndTeam2(team1, team2, pageable);
        List<MatchModel> matches = pagedMatches.getContent();
        if(matches.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Match not found!");
        } else {
            MatchResponse matchResponse = new MatchResponse();
            matchResponse.setContent(matches);
            matchResponse.setPageNo(pagedMatches.getNumber());
            matchResponse.setPageSize(pagedMatches.getSize());
            matchResponse.setTotalItems(pagedMatches.getTotalElements());
            matchResponse.setTotalPages(pagedMatches.getTotalPages());
            matchResponse.setLast(pagedMatches.isLast());
            return matchResponse;
        }
    }

    @Override
    public MatchResponse getMatchByVenue(String venue, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<MatchModel> pagedMatches = matchRepository.findByVenueContainingIgnoreCase(venue, pageable);
        List<MatchModel> matches = pagedMatches.getContent();
        if(matches.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Match not found!");
        } else {
            MatchResponse matchResponse = new MatchResponse();
            matchResponse.setContent(matches);
            matchResponse.setPageNo(pagedMatches.getNumber());
            matchResponse.setPageSize(pagedMatches.getSize());
            matchResponse.setTotalItems(pagedMatches.getTotalElements());
            matchResponse.setTotalPages(pagedMatches.getTotalPages());
            matchResponse.setLast(pagedMatches.isLast());
            return matchResponse;
        }
    }

    @Override
    public MatchResponse getMatchByWinner(String winner, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<MatchModel> pagedMatches = matchRepository.findByWinnerContainingIgnoreCase(winner, pageable);
        List<MatchModel> matches = pagedMatches.getContent();
        if(matches.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Match not found!");
        } else {
            MatchResponse matchResponse = new MatchResponse();
            matchResponse.setContent(matches);
            matchResponse.setPageNo(pagedMatches.getNumber());
            matchResponse.setPageSize(pagedMatches.getSize());
            matchResponse.setTotalItems(pagedMatches.getTotalElements());
            matchResponse.setTotalPages(pagedMatches.getTotalPages());
            matchResponse.setLast(pagedMatches.isLast());
            return matchResponse;
        }
    }

    @Override
    public MatchResponse getMatchByTargetRuns(Integer targetRuns, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<MatchModel> pagedMatches = matchRepository.findByTargetRunsGreaterThan(targetRuns, pageable);
        List<MatchModel> matches = pagedMatches.getContent();
        if(matches.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Match not found!");
        } else {
            MatchResponse matchResponse = new MatchResponse();
            matchResponse.setContent(matches);
            matchResponse.setPageNo(pagedMatches.getNumber());
            matchResponse.setPageSize(pagedMatches.getSize());
            matchResponse.setTotalItems(pagedMatches.getTotalElements());
            matchResponse.setTotalPages(pagedMatches.getTotalPages());
            matchResponse.setLast(pagedMatches.isLast());
            return matchResponse;
        }
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
