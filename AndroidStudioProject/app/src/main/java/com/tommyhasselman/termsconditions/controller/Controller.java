package com.tommyhasselman.termsconditions.controller;

import com.tommyhasselman.termsconditions.model.*;

public class Controller {

    public Player player; // Player object.

    public int orderSize; // The amount of items in a order;
    public double incorrectItemChance; // This value is the percentage chance of an item being incorrect.
    public double missingItemChance; // This value is the percentage chance of an item being missing.


    /**
     * Default Constructor.
     */
    public Controller(Player player) {
        this.player = player;
        orderSize = 3;
        incorrectItemChance = 0.25;
        missingItemChance = 0.05;
    }

    public Order newOrder() {
        return new Order(this);
    }



}
