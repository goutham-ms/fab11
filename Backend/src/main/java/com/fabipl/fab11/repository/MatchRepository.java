package com.fabipl.fab11.repository;

import com.fabipl.fab11.model.MatchModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<MatchModel, Integer> {
    List<MatchModel> findBySeason(Integer season);

    List<MatchModel> findByPlayerOfMatch(String playerOfMatch);

    List<MatchModel> findByTeam1(String team);

    List<MatchModel> findByTeam1AndTeam2(String team1, String team2);

    List<MatchModel> findByVenue(String venue);

    List<MatchModel> findByWinner(String winner);

    List<MatchModel> findByTargetRuns(Integer targetRuns);
}
