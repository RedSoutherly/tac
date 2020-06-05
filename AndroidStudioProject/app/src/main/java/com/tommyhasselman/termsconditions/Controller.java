package com.tommyhasselman.termsconditions;

import android.app.Application;

import com.tommyhasselman.termsconditions.model.*;

/**
 *Controller is an Application and hence all activities have permissions to view its varibales,
 * which centralises main variables needed between the different main classes. it also centralises
 * a few other simple methods such as generating a new order.
 */
public class Controller extends Application {

    public Player player = new Player(); // Player object.

    public int orderSize = 3; // The amount of items in a order;
    public double incorrectItemChance = 0.25; // This value is the percentage chance of an item being incorrect.
    public double missingItemChance = 0.05; // This value is the percentage chance of an item being missing.

    public Controller() { }

    public Order newOrder() {
        return new Order(this);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
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
