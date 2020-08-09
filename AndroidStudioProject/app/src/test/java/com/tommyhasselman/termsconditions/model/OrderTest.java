package com.tommyhasselman.termsconditions.model;

import com.tommyhasselman.termsconditions.Controller;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class OrderTest {

    private Order o;

    @Before
    public void setUp() throws Exception {

        o = new Order(new Controller());

    }
/*
    @Test
    public void getOrderedCodes() {

        BasicItem b1 = new BasicItem();
        BasicItem b2 = new BasicItem();
        BasicItem b3 = new BasicItem();

        String concodes = (b1.getCode() + b2.getCode() + b3.getCode());

        ArrayList<OrderItem> list = new ArrayList<>();
        list.add(b1);
        list.add(b2);
        list.add(b3);

        o.setOrdered(list);

        assertEquals(concodes, o.getOrderedCodes());

    }

    @Test
    public void getPackedCodes() {

        BasicItem b1 = new BasicItem();
        BasicItem b2 = new BasicItem();
        BasicItem b3 = new BasicItem();

        String concodes = (b1.getCode() + b2.getCode() + b3.getCode());

        ArrayList<OrderItem> list = new ArrayList<>();
        list.add(b1);
        list.add(b2);
        list.add(b3);

        o.setPacked(list);

        assertEquals(concodes, o.getPackedCodes());

    }
    
 */
}