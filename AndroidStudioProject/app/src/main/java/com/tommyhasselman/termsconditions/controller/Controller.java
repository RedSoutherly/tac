package com.tommyhasselman.termsconditions.controller;

import com.tommyhasselman.termsconditions.model.*;

public class Controller {

    public Player player; // Player object.

    public int orderSize; // The amount of items in a order;
    public double incorrectItemChance; // This value is the percentage chance of an item being incorrect.


    /**
     * Default Constructor.
     */
    public Controller() {
        player = new Player();

        orderSize = 3;
        incorrectItemChance = 0.25;
    }

    public Order newOrder() {
        return new Order(this);
    }

}
