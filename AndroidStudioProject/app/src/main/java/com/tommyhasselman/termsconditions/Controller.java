package com.tommyhasselman.termsconditions;

import android.app.Activity;
import android.app.Application;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayersClient;
import com.tommyhasselman.termsconditions.model.Order;
import com.tommyhasselman.termsconditions.playServices.*;

import static com.google.android.gms.games.Games.getPlayersClient;

/**
 * Controller is an extension of the Application and hence all activities have permissions to view its variables.
 * Which centralises main variables needed between the different main classes. It also centralises
 * a few other simple methods such as generating a new order.
 */
public class Controller extends Application {

    private GoogleSignInAccount signedInAccount;
    private Player player;
    private String playerDisplayName = "null";

    // Player variables
    public int previousRoundScore;
    public int lifetimeScore;
    public int balanceEarnt;
    public int balance;
    public int payRate = 5; // The current amount of pay you get per correct order evaluation.

    // Order variables
    public int orderSize = 3; // The amount of items in a order;
    public double incorrectItemChance = 0.25; // This value is the percentage chance of an item being incorrect.
    public double missingItemChance = 0.05; // This value is the percentage chance of an item being missing.


    /**
     * @return returns an instance of Order.
     */
    public Order newOrder() {
        return new Order(this);
    }

    /**
     * This method updates the player variables when called.
     * @param ordersComplete The total number of correctly screened orders.
     */
    public void endRound(int ordersComplete) {
        previousRoundScore = ordersComplete;
        lifetimeScore += previousRoundScore;
        balanceEarnt = (ordersComplete * payRate);
        balance += balanceEarnt;
    }

    /**
     * @return returns the number of correctly screened packages from the latest round as an int.
     */
    public int getPreviousRoundScore() {
        return previousRoundScore;
    }

    /**
     * @return return the total number of correctly screened packages as an int.
     */
    public int getLifetimeScore() {
        return lifetimeScore;
    }

    /**
     * @return returns the balance earn't from the latest round as an int.
     */
    public int getBalanceEarnt() {
        return balanceEarnt;
    }

    /**
     * @return returns the total balance earn't as an int.
     */
    public int getBalance() {
        return balance;
    }

    /**
     * @return returns the current pay rate as an int.
     */
    public int getPayRate() {
        return payRate;
    }

    /**
     * @return returns the current order size as an int.
     */
    public int getOrderSize() {
        return orderSize;
    }

    /**
     * @return returns the incorrect item chance as a double.
     */
    public double getIncorrectItemChance() {
        return incorrectItemChance;
    }

    /**
     * @return returns the missing item chance as a double.
     */
    public double getMissingItemChance() {
        return missingItemChance;
    }

    public void setPreviousRoundScore(int previousRoundScore) {
        this.previousRoundScore = previousRoundScore;
    }

    public void setLifetimeScore(int lifetimeScore) {
        this.lifetimeScore = lifetimeScore;
    }

    public void setBalanceEarnt(int balanceEarnt) {
        this.balanceEarnt = balanceEarnt;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setPayRate(int payRate) {
        this.payRate = payRate;
    }

    public void setOrderSize(int orderSize) {
        this.orderSize = orderSize;
    }

    public void setIncorrectItemChance(double incorrectItemChance) {
        this.incorrectItemChance = incorrectItemChance;
    }

    public void setMissingItemChance(double missingItemChance) {
        this.missingItemChance = missingItemChance;
    }

    public void setSignedInAccount(GoogleSignInAccount signedInAccount) {
        this.signedInAccount = signedInAccount;
        //player = (Player) getPlayersClient(this, signedInAccount).getCurrentPlayer();
        //playerDisplayName = player.getDisplayName();
    }

    public Player getPlayer() {
        return player;
    }

    public String getPlayerDisplayName() {
        return playerDisplayName;
    }
}
