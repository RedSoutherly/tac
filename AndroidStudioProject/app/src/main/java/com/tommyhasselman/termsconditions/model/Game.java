package com.tommyhasselman.termsconditions.model;

import java.util.ArrayList;
import java.util.Timer;

public class Game {

    //master list of objects (is this necessary?)
    private ArrayList<GameObject> objects;
    private Player player;
    private enum Phase{
            MAINMENU,
            GAME,
            CINIMATIC
    };
    private Timer time;

    public Game (){
        this.objects = new ArrayList<GameObject>();
        time = new Timer();
        //game by default in the alpha should be main menu
        Phase phase = Phase.GAME;
    }

    /**
     *
     * starts the game
     * in alpha it starts a timer and generates boxes
     */
    public void startGame(){
        
    }

    public ArrayList<GameObject> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<GameObject> objects) {
        this.objects = objects;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
