package com.tommyhasselman.termsconditions.model;

import java.io.Serializable;
import java.util.Random;

/**
 * Story tree node is a wrapper that holds a given cinimatic and holds a set of children (2 atm)
 *
 */
@SuppressWarnings("unused")
public class StoryTreeNode implements Serializable {

    private StoryTreeNode left;
    private StoryTreeNode right;
    private Cinematic scenario;

    public StoryTreeNode(Cinematic scenario) {
        this.left = null;
        this.right = null;
        this.scenario = scenario;//you can pass in null that's all good
    }

    public void setScenario(Cinematic scenario) {
        this.scenario = scenario;
    }

    public Cinematic getCinematic() {
        if (this.scenario == null) {
            this.scenario = new Cinematic();
            return scenario;
        }
        return scenario;
    }
    //switch to support a possibility of more than binary trees
    public StoryTreeNode getRandomNode() {
        Random r = new Random();
        int x = r.nextInt(2);
        switch (x) {
            case (0):
                return right;
            default:
                return left;
        }

    }

    public void setRight(StoryTreeNode right) {
        this.right = right;
    }

    public void setLeft(StoryTreeNode left) {
        this.left = left;
    }

}
