package com.tommyhasselman.termsconditions.model;

import java.util.Random;

public class StoryTreeNode {

    StoryTreeNode left;
    StoryTreeNode right;
    Cinematic scenario;

    public StoryTreeNode(Cinematic scenario){
        this.left=null;
        this.right=null;
        this.scenario=scenario;//you can pass in null that's all good
        if(scenario!=null){
            switch(scenario.getEventCode()){
                case 1:
                    
                    break;
                default:

                    break;
            }
        }
    }
    public void setScenario(Cinematic scenario){
        this.scenario=scenario;
    }
    public Cinematic getCinematic(){
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
