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
public class BasicItem extends OrderItem {

    private String code;
    private String size;
    private String colour;
    private String product;

    private int intSize;
    private int argbColour;

    /**
     * Default constructor for Basic Item.
     * Constructs an instance with all fields randomised.
     */
    public BasicItem() {
        Random r = new Random();
        int rs = r.nextInt(sizes.length);
        int rc = r.nextInt(colours.length);
        int rp = r.nextInt(basicProducts.length);
        code = "SCP" + rs + rc + rp;
        System.out.println(code);
        size = sizes[rs];
        intSize = intSizes[rs];
        colour = colours[rc];
        argbColour = argbColours[rc];
        product = basicProducts[rp];
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
}
