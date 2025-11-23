package com.example.backend.controller;
import com.example.backend.models.RankedPlayer;
import java.util.*;
import java.io.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.service.LeaderboardService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LeaderboardController {

    private final LeaderboardService service;

    public LeaderboardController(LeaderboardService service) {
        this.service = service;
    }

    @GetMapping("/leaderboard")
    public List<RankedPlayer> getLeaderBoard() throws Exception {
        return service.getLeaderBoard();
    }
}
