package com.tommyhasselman.termsconditions;

import android.app.Application;

import com.tommyhasselman.termsconditions.model.*;

/**
 *Controller is an Application and hence can be viewed 
 */
public class Controller extends Application {

    public int previousRoundScore;
    public int lifetimeScore;
    public int balanceEarnt;
    public int balance;
    public int payRate = 5; // The current amount of pay you get per correct order evaluation.

    public int orderSize = 3; // The amount of items in a order;
    public double incorrectItemChance = 0.25; // This value is the percentage chance of an item being incorrect.
    public double missingItemChance = 0.05; // This value is the percentage chance of an item being missing.

    public Controller() { }

    public Order newOrder() {
        return new Order(this);
    }

    public void endRound(int ordersComplete) {
        previousRoundScore = ordersComplete;
        lifetimeScore += previousRoundScore;
        balanceEarnt = (ordersComplete * payRate);
        balance += balanceEarnt;
    }

    public int getBalance() {
        return balance;
    }

    public int getBalanceEarnt() {
        return balanceEarnt;
    }

    public int getPreviousRoundScore() {
        return previousRoundScore;
    }

    public int getOrderSize() {
        return orderSize;
    }

    public void setOrderSize(int orderSize) {
        this.orderSize = orderSize;
    }

    public double getIncorrectItemChance() {
        return incorrectItemChance;
    }

    public void setIncorrectItemChance(double incorrectItemChance) {
        this.incorrectItemChance = incorrectItemChance;
    }

    public double getMissingItemChance() {
        return missingItemChance;
    }

    public void setMissingItemChance(double missingItemChance) {
        this.missingItemChance = missingItemChance;
    }
}
