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

    @Query("SELECT m FROM MatchModel m WHERE m.playerOfMatch LIKE %:player%")
    List<MatchModel> findByPlayerOfMatch(@Param("player") String playerOfMatch);

    @Query("SELECT m FROM MatchModel m WHERE m.team1 LIKE %:team% OR m.team2 LIKE %:team%")
    List<MatchModel> findByTeam(@Param("team") String team);

    @Query("SELECT m FROM MatchModel m WHERE (m.team1 LIKE %:teamA% AND m.team2 LIKE %:teamB%)"
    + "OR (m.team1 LIKE %:teamB% AND m.team2 LIKE %:teamA%)")
    List<MatchModel> findByTeam1AndTeam2(@Param("teamA") String team1, @Param("teamB") String team2);

    List<MatchModel> findByVenueContainingIgnoreCase(String venue);

    List<MatchModel> findByWinnerContainingIgnoreCase(String winner);

    List<MatchModel> findByTargetRunsGreaterThan(Integer targetRuns);

    @Query("SELECT m FROM MatchModel m WHERE m.date = :date OR m.venue = :venue OR m.city = :city")
    Optional<MatchModel> findDuplicateMatch(@Param("date")LocalDate date, @Param("venue") String venue, @Param("city") String city);
}
