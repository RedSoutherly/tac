package com.tommyhasselman.termsconditions.model;

import android.graphics.Color;

/**
 * A very basic constructor for alpha that generates items with different random attributes.
 */
public abstract class OrderItem extends GameObject {

    protected String[] basicProducts = {
            "Hat",
            "Dildo",
            "Ball",
            "Fleshlight",
            "Riot Shield"
    };

    protected String[] sizes = {
            "Small",
            "Medium",
            "Large"
    };

    protected int[] intSizes = {
            250,
            350,
            450
    };

    protected String[] colours = {
            "Red",
            "Green",
            "Blue",
            "Yellow",
            "Magenta"
    };

    protected int[] argbColours = {
            Color.argb(50,255,0,0),
            Color.argb(50,0,255,0),
            Color.argb(50,0,0,255),
            Color.argb(50,0,255,255),
            Color.argb(50,255,255,0)
    };

    /**
     * @return the unique identifying code for a given object
     */
    public abstract String getCode();

    public abstract int getArgbColour();

    public abstract int getIntSize();

}
