package com.tommyhasselman.termsconditions.model;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

import com.tommyhasselman.termsconditions.R;

/**
 * A very basic constructor for alpha that generates items with different random attributes.
 */
public abstract class OrderItem extends GameObject {

    protected String[] basicProducts = {
            "Dildo",
            "Cute Ball",
            "Pokeball",
            "Star Ball",
            "Flower Hat",
            "Star Hat",
            "BLM Shirt",
            "Lolita Shirt",
            "MAGA Shirt"
    };


    protected int[] basicDrawables = {
            R.drawable.dildo,
            R.drawable.ball_cute,
            R.drawable.ball_poke,
            R.drawable.ball_star,
            R.drawable.hat_flower,
            R.drawable.hat_star,
            R.drawable.shirt_blm,
            R.drawable.shirt_loli,
            R.drawable.shirt_maga
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

    public abstract int getDrawable();

}
