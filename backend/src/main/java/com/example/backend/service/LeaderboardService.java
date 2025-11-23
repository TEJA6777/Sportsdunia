package com.example.backend.service;
import java.util.*;
import java.io.*;
import org.springframework.stereotype.Service;

import com.example.backend.models.Event;
import com.example.backend.models.Player;
import com.example.backend.models.RankedPlayer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LeaderboardService {
    
    private static final Map<String, Integer> SCORE_RULES = Map.of(
        "TAKE_WICKET",20,
        "50_RUNS_MILESTONE",15,
        "HIT_SIX",2,
        "HIT_FOUR",1
    );

    public List<RankedPlayer> getLeaderBoard() throws Exception {
        
        ObjectMapper mapper = new ObjectMapper();

        InputStream playerStream = getClass().getResourceAsStream("/players.json");
        InputStream eventStream = getClass().getResourceAsStream("/events.json");

        List<Player> players = mapper.readValue(playerStream, new TypeReference<>() {});
        List<Event> events = mapper.readValue(eventStream, new TypeReference<>() {});

        Map<Integer, Integer> scoreMap = new HashMap<>();
        for (Event ev : events) {
            int delta = SCORE_RULES.getOrDefault(ev.getAction(), 0);
            scoreMap.put(ev.getPlayerId(), scoreMap.getOrDefault(ev.getPlayerId(), 0) + delta);
        }

        for (Player p : players) {
            scoreMap.putIfAbsent(p.getId(), 0);
        }

        List<RankedPlayer> list = new ArrayList<>();
        players.forEach(p -> list.add(new RankedPlayer(p.getId(), p.getName(), scoreMap.get(p.getId()), 0)));
        list.sort((a, b) -> b.getScore() - a.getScore());

        int prevScore = -1, rank = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getScore() != prevScore) {
                rank = i + 1;
                prevScore = list.get(i).getScore();
            }
            list.set(i, new RankedPlayer(
                    list.get(i).getId(),
                    list.get(i).getName(),
                    list.get(i).getScore(),
                    rank
            ));
        }

        return list;
    } 
}
