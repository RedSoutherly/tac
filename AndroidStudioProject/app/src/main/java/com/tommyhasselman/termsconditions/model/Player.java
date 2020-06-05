package com.tommyhasselman.termsconditions.model;

/**
 * Player is responsible for tracking all of the variables for a given players game
 */
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

    public void set$(double $) {
        this.$=$;
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
