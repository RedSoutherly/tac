package com.tommyhasselman.termsconditions.model;

/**
 *a very basic constructor for alpha that generates items with differnt random atributes
 */
public abstract class OrderItem extends GameObject {

    String[] basicProducts = {
            "Hat",
            "Dildo",
            "Ball"
    };

    String[] sizes = {
            "Small",
            "Medium",
            "Large"
    };

    String[] colours = {
            "Red",
            "Green",
            "Blue"
    };

    /**
     * @return the unique identifying code for a given object
     */
    public abstract String getCode();

}
