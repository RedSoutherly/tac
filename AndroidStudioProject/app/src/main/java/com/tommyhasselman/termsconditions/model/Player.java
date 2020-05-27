package com.tommyhasselman.termsconditions.model;

public class Player {
    private boolean alive;
    private int score;
    private double $;

    public Player() {
        this.alive = true;
        this.score = 0;
    }
    public void incrementScore(){
        score++;
    }

    public double get$() {
        return $;
    }

    public void increment$(int $) {
        this.$ += score*2;
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
