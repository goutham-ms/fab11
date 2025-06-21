package com.fabipl.fab11.service;

import com.fabipl.fab11.model.MatchModel;

import java.util.List;

public interface MatchService {
   List<MatchModel> getAllMatches();

   List<MatchModel> getMatchBySeason(Integer season);
   List<MatchModel> getMatchByPlayerOfMatch(String playerOfMatch);
   List<MatchModel> getMatchByTeam(String team);
   List<MatchModel> getMatchByTeam1AndTeam2(String team1, String team2);
   List<MatchModel> getMatchByVenue(String venue);
   List<MatchModel> getMatchByWinner(String winner);
   List<MatchModel> getMatchByTargetRuns(Integer targetRuns);

   List<MatchModel> updateMatch(Integer id);
   List<String> deleteMatch(Integer id);

}
