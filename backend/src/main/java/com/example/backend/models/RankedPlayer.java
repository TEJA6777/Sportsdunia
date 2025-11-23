package com.example.backend.models;

public class RankedPlayer {
    private int id;
    private String name;
    private int score;
    private int rank;

    public RankedPlayer(int id, String name, int score, int rank) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.rank = rank;
    }

    public int getId() { 
        return id; 
    }
    public String getName() { 
        return name; 
    }
    public int getScore() {
         return score; 
        }
    public int getRank() {
         return rank; 
        }
}
