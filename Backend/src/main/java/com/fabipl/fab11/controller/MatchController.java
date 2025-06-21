package com.fabipl.fab11.controller;

import com.fabipl.fab11.model.MatchModel;
import com.fabipl.fab11.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MatchController {
    @Autowired
    private MatchService matchService;

    @GetMapping("/public/match")
    public List<MatchModel> getAllMatch() {
        return matchService.getAllMatches();
    }
}
