package com.tommyhasselman.termsconditions.model;

import android.graphics.Color;

import com.tommyhasselman.termsconditions.R;

/**
 * A very basic constructor for alpha that generates items with different random attributes.
 */
public abstract class OrderItem {

    protected int plainProductBoundary = 5;

    protected String[] productTypes = {
            "Ball",
            "Dildo",
            "Hat",
            "Riot Shield",
            "Shirt",

            "Butterfly Ball",
            "Pokeball",
            "Star Ball",

            "Flower Hat",
            "Star Hat",

            "Patterned Riot Shield",

            "BLM Shirt",
            "Loli Shirt",
            "MAGA Shirt"
    };

    protected int[] drawables = {
            R.drawable.p_ball_plain,
            R.drawable.p_dildo,
            R.drawable.p_hat_plain,
            R.drawable.p_riotshield,
            R.drawable.p_shirt_plain,

            R.drawable.p_ball_cute,
            R.drawable.p_ball_poke,
            R.drawable.p_ball_star,

            R.drawable.p_hat_flower,
            R.drawable.p_hat_star,

            R.drawable.p_riotshield_cute,

            R.drawable.p_shirt_blm,
            R.drawable.p_shirt_loli,
            R.drawable.p_shirt_maga
    };

    protected int[] labbelledDrawables = {
            R.drawable.p_ball_plain_labelled,
            R.drawable.p_dildo_labelled,
            R.drawable.p_hat_plain_labelled,
            R.drawable.p_riotshield_labelled,
            R.drawable.p_shirt_plain_labelled,

            R.drawable.p_ball_cute_labelled,
            R.drawable.p_ball_poke_labelled,
            R.drawable.p_ball_star_labelled,

            R.drawable.p_hat_flower_labelled,
            R.drawable.p_hat_star_labelled,

            R.drawable.p_riotshield_cute_labelled,

            R.drawable.p_shirt_blm_labelled,
            R.drawable.p_shirt_loli_labelled,
            R.drawable.p_shirt_maga_labelled
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
