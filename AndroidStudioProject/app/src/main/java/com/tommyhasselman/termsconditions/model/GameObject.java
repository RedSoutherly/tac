package com.tommyhasselman.termsconditions.model;

import java.io.File;

/**
 * the GameObject super class defines the common methods and variables shared
 * by all GameObject's
 */

public abstract class GameObject {
    private int posX;
    private int posY;
    private double size;
    private File sprite;
    private String name;

    public void draw(){
    //to be overridden
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public File getSprite() {
        return sprite;
    }

    public void setSprite(File sprite) {
        this.sprite = sprite;
    }

    public void move(int x, int y){
        this.setPosX(x);
        this.setPosX(y);
    }

    /**
     * will often be overwritten with a more complex to string in order to
     * compare differnt but similar irems
     *
     * @return a string reresentation of the object
     */
    public String toString(){
        return name;
    }
}
