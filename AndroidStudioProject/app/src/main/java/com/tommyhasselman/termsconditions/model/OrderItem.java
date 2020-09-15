package com.tommyhasselman.termsconditions.model;

import android.graphics.Color;

import com.tommyhasselman.termsconditions.R;

/**
 * Order Item is the abstract class that defines values for use in the Item class.
 */
public abstract class OrderItem {

    /**
     * The index boundary where the flavoured products begin.
     */
    protected int plainProductBoundary = 5;

    /**
     * The String array of product types. All plain types are at the beginning of the array,
     * followed by flavoured types.
     */
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
            "Loli Shirt"
    };

    /**
     * The int array of drawable resource values, which line up with the corresponding product types.
     */
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
            R.drawable.p_shirt_loli
    };

    /**
     * The int array of drawable resource values, which line up with the corresponding product types.
     * These drawables have labels.
     */
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
            R.drawable.p_shirt_loli_labelled
    };

    /**
     * String array of size values.
     */
    protected String[] sizes = {
           // "Small",
           // "Medium",
            "Large"
    };

    /**
     * int array of size values.
     */
    protected int[] intSizes = {
            //250,
            //350,
            450
    };

    /**
     * String array of colours.
     */
    protected String[] colours = {
            "Red",
            "Green",
            "Blue",
            "Yellow",
            "Magenta"
    };

    /**
     * int array of aRGB values.
     */
    protected int[] argbColours = {
            Color.argb(50,255,0,0),
            Color.argb(50,0,255,0),
            Color.argb(50,0,0,255),
            Color.argb(50,0,255,255),
            Color.argb(50,255,255,0)
    };

    /**
     * @return Returns the unique identifying code for this item.
     */
    public abstract String getCode();

    /**
     * @return Returns the aRGB int value for this item.
     */
    public abstract int getArgbColour();

    /**
     * @return Returns the int size value for this item.
     */
    public abstract int getIntSize();

    /**
     * @return Returns the resource int value for the drawable of this item.
     */
    public abstract int getDrawable();

}
