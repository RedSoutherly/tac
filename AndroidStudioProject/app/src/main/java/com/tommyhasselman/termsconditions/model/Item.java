package com.tommyhasselman.termsconditions.model;

import androidx.annotation.NonNull;

import java.util.Random;

/**
 * The Basic Item class is the first level of difficulty
 * for matching product collections visually.
 *
 * There are three aspects to each product of this type:
 *  Size, Colour, and Product.
 *
 * The possible values for these fields are defined in the super class.
 *
 * @author Tommy Hasselman
 */
public class Item extends OrderItem {

    private String code;
    private String size;
    private String colour;
    private String product;

    private int intSize;
    private int argbColour;
    private int drawable;

    /**
     * Default constructor for Basic Item.
     * Constructs an instance with all fields randomised.
     */
    public Item(int complexity) {
        Random r = new Random();

        int rProductRange = plainProductBoundary;
        boolean labelled = true;

        switch (complexity) {
            case 0:
                break;
            case 1:
                rProductRange = plainProductBoundary;
                labelled = false;
                break;
            case 2:
                rProductRange = productTypes.length;
                labelled = true;
                break;
            case 3:
                rProductRange = productTypes.length;
                labelled = false;
                break;
        }

        int rProductIndex = r.nextInt(rProductRange);
        product = productTypes[rProductIndex];

        if (labelled) {
            drawable = labbelledDrawables[rProductIndex];
        } else {
            drawable = drawables[rProductIndex];
        }

        int rs = r.nextInt(sizes.length);
        int rc = r.nextInt(colours.length);

        size = sizes[rs];
        intSize = intSizes[rs];
        colour = colours[rc];
        argbColour = argbColours[rc];

        code = "SCP" + rs + rc + rProductIndex;
    }

    /**
     * Custom toString() writes a description of the item.
     * @return Returns the description as a String
     */
    @NonNull
    public String toString() {
        return (size+" "+colour+" "+product);
    }

    /**
     * Method for accessing the code field.
     * @return Returns code String
     */
    public String getCode() {
        return code;
    }

    public int getArgbColour() {
        return argbColour;
    }

    public int getIntSize() {
        return intSize;
    }

    public int getDrawable() { return  drawable; }
}
