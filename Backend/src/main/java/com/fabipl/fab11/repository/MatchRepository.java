package com.fabipl.fab11.repository;

import com.fabipl.fab11.model.MatchModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<MatchModel, Integer> {

    Page<MatchModel> findAll(Pageable pageable);

    Page<MatchModel> findBySeason(Integer season, Pageable pageable);

    @Query("SELECT m FROM MatchModel m WHERE m.playerOfMatch LIKE %:player%")
    Page<MatchModel> findByPlayerOfMatch(@Param("player") String playerOfMatch, Pageable pageable);

    @Query("SELECT m FROM MatchModel m WHERE m.team1 LIKE %:team% OR m.team2 LIKE %:team%")
    Page<MatchModel> findByTeam(@Param("team") String team, Pageable pageable);

    @Query("SELECT m FROM MatchModel m WHERE (m.team1 LIKE %:teamA% AND m.team2 LIKE %:teamB%)"
    + "OR (m.team1 LIKE %:teamB% AND m.team2 LIKE %:teamA%)")
    Page<MatchModel> findByTeam1AndTeam2(@Param("teamA") String team1, @Param("teamB") String team2, Pageable pageable);

    Page<MatchModel> findByVenueContainingIgnoreCase(String venue, Pageable pageable);

    Page<MatchModel> findByWinnerContainingIgnoreCase(String winner, Pageable pageable);

    Page<MatchModel> findByTargetRunsGreaterThan(Integer targetRuns, Pageable pageable);

    @Query("SELECT m FROM MatchModel m WHERE m.date = :date OR m.venue = :venue OR m.city = :city")
    Optional<MatchModel> findDuplicateMatch(@Param("date")LocalDate date, @Param("venue") String venue, @Param("city") String city);
}
