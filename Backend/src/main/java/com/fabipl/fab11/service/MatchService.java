package com.fabipl.fab11.service;

import com.fabipl.fab11.dto.MatchResponse;
import com.fabipl.fab11.model.MatchModel;



public interface MatchService {
   MatchResponse getAllMatches(int pageNo, int pageSize);

   MatchResponse getMatchBySeason(Integer season, int pageNo, int pageSize);
   MatchResponse getMatchByPlayerOfMatch(String playerOfMatch, int pageNo, int pageSize);
   MatchResponse getMatchByTeam(String team, int pageNo, int pageSize);
   MatchResponse getMatchByTeam1AndTeam2(String team1, String team2, int pageNo, int pageSize);
   MatchResponse getMatchByVenue(String venue, int pageNo, int pageSize);
   MatchResponse getMatchByWinner(String winner, int pageNo, int pageSize);
   MatchResponse getMatchByTargetRuns(Integer targetRuns, int pageNo, int pageSize);

   String addMatch(MatchModel match);
   String updateMatch(Integer id, MatchModel match);
   String deleteMatch(Integer id);

}
