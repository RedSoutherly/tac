package com.tommyhasselman.termsconditions;

import com.tommyhasselman.termsconditions.model.Order;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ControllerTest {

    Controller c;

    @Before
    public void setUp() throws Exception {

        c = new Controller();
        c.setLifetimeScore(50);
        c.setBalance(20);
        c.setPayRate(5);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void newOrder() {

        Order o = c.newOrder();

        assertNotNull(o);

    }

    @Test
    public void endRound() {

        c.endRound(10);

        assertEquals(10, c.getPreviousRoundScore());
        assertEquals(60, c.getLifetimeScore());
        assertEquals(50, c.getBalanceEarnt());
        assertEquals(70, c.getBalance());

    }
}