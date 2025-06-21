package com.fabipl.fab11.service;

import com.fabipl.fab11.model.MatchModel;
import com.fabipl.fab11.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IMatchService implements MatchService {
    @Autowired
    private MatchRepository matchRepository;

    @Override
    public List<MatchModel> getAllMatches() {
        return matchRepository.findAll();
    }
}
