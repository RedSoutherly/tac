package com.tommyhasselman.termsconditions.model;

public class Player {
    private boolean alive;
    private int score;

    public Player() {
        this.alive = true;
        this.score = 0;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
