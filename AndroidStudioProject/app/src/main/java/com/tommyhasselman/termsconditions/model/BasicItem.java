package com.tommyhasselman.termsconditions.model;

import java.util.Random;

/**
 *
 */
public class BasicItem extends OrderItem {

    String size;
    String colour;
    String product;

    public BasicItem() {
        Random r = new Random();
        size = sizes[r.nextInt(sizes.length)];
        colour = colours[r.nextInt(colours.length)];
        product = basicProducts[r.nextInt(basicProducts.length)];
    }

    public String toString() {
        return (size+" "+colour+" "+product);
    }


}
