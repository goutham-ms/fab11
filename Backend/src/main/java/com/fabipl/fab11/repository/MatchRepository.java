package com.fabipl.fab11.repository;

import com.fabipl.fab11.model.MatchModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<MatchModel, Integer> {
    List<MatchModel> findBySeason(Integer season);

    List<MatchModel> findByPlayerOfMatch(String playerOfMatch);

    List<MatchModel> findByTeam1(String team);

    List<MatchModel> findByTeam1AndTeam2(String team1, String team2);

    List<MatchModel> findByVenue(String venue);

    List<MatchModel> findByWinner(String winner);

    List<MatchModel> findByTargetRuns(Integer targetRuns);

    @Query("SELECT m FROM MatchModel m WHERE m.date = :date OR m.venue = :venue OR m.city = :city")
    Optional<MatchModel> findDuplicateMatch(@Param("date")LocalDate date, @Param("venue") String venue, @Param("city") String city);
}
