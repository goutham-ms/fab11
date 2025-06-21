package com.fabipl.fab11.repository;

import com.fabipl.fab11.model.MatchModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<MatchModel, Integer> {
}
