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
    //TODO address protection of methods in this class
    public Game (){
        this.objects = new ArrayList<GameObject>();
        time = new Timer();
        //game by default in the alpha should be main menu
        Phase phase = Phase.GAME;
    }

    /**
     *
     * runs a loop to loop between cinematic and game
     * until the player dies or a certain number of rounds are passed
     */
    public void runGame(){


    }
    /**
     * generates the choices you use between rounds of the game
     * takes input and saves your choices for scoring
     */
    public void startCinematic(){

    }

    /**
     *
     * starts the game
     * in alpha it starts a timer and generates boxes
     * you can then match boxes and itineraries
     */
    public void startGame(){
        //time.start();

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
