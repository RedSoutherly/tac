package com.tommyhasselman.termsandconditions.model;

import androidx.annotation.NonNull;

import java.util.Random;

/**
 * The Item class defines any single item in the game for possible combinations.
 * It has one constructor which takes a complexity value. And seven data fields.
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
     * Constructor for Item.
     * Constructs an instance of Item using randomly picked indexes bases on a complexity.
     * Complexity ranges from 0 to 3 with 0 being the default. A Complexity of zero means the item
     * will be a plain product with a labelled drawable. Level 1 gives a plain product with an
     * unlabelled drawable. Level 2 gives the opportunity for a flavoured product with a labelled
     * drawable. And 3 also gives the opportunity for a flavoured product with a unlabelled
     * drawable.
     * @param complexity The given complexity level for this item.
     */
    public Item(int complexity) {
        Random r = new Random();

        int rProductRange = plainProductBoundary;
        boolean labelled = true;

        switch (complexity) {
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
            default:
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

        code = "S" + rs + "C" + rc + "P" + rProductIndex;
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
     * Method for accessing the code field. The code for an item is the a String of "S" followed
     * by the random size index, "C" followed by the random colour index and "P" followed by the
     * random product index. E.G S2C4P10
     * @return Returns code String value.
     */
    public String getCode() {
        return code;
    }

    /**
     * Getter for the ARGB value of the item.
     * @return Returns an int ARGB value.
     */
    public int getArgbColour() {
        return argbColour;
    }

    /**
     * Getter for the size of the item.
     * @return Returns an int value for the item size.
     */
    public int getIntSize() {
        return intSize;
    }

    /**
     * Getter for the item drawable.
     * @return Returns the int value for a drawable resource.
     */
    public int getDrawable() {
        return  drawable;
    }
}
