package com.tommyhasselman.termsconditions.model;

import java.util.List;
import java.util.ArrayList;

/** Class Box that compares the contents of the box/parcel to what should be in the box/parcel */
public class Box extends GameObject {
    
    List<OrderItem> box_contains = new ArrayList<OrderItem>();

    List<OrderItem> box_should_contain = new ArrayList<OrderItem>();

}
