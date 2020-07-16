package com.tommyhasselman.termsconditions.model;

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
            "Large",
            "Mediocre",
            "Grande"
    };

    protected String[] colours = {
            "Red",
            "Green",
            "Blue",
            "Yellow",
            "Magenta"
    };

    /**
     * @return the unique identifying code for a given object
     */
    public abstract String getCode();

}
