package com.tommyhasselman.termsconditions.model;

import java.util.Random;

public class StoryTreeNode {
    StoryTreeNode left;
    StoryTreeNode right;
    Cinematic scenario;

    public StoryTreeNode(Cinematic scenario){
        this.left=null;
        this.right=null;
        this.scenario=scenario;//you can pass in null thats all good
    }
    public void setScenario(Cinematic scenario){
        this.scenario=scenario;
    }
    public Cinematic getScenario(){
        if(scenario==null){
            this.scenario=new Cinematic();
            return scenario;
        }
        return scenario;
    }

    public StoryTreeNode getRandomNode() {
        Random r = new Random();
        int x = r.nextInt(1);
        switch (x) {
            case (1):
                return left;

            case (0):
                return right;
            default:
                return left;
        }

    }

}
