package com.tommyhasselman.termsconditions.model;

import java.util.Random;

/**
 * An instance of cinimatic contains a scenario and 2 related choices generated at random
 */
public class Cinematic {
        private String[] Choice1 = {"Pay for medication -$50", "Pay for home heating -$30", "Pay to fix the toilet -$70", "Book a psychologist appointment -$80"};
        private String[] Choice2 = {"Pray the sickness away", "Endure the cold", "Attempt to fix it yourself", "Grin and bear it"};
        private String[] Scenario = {"Your nephew is sick, do you;", "Winter is coming:", "Your toilet is broken, do you;", "Your mental health is at an all time low, do you;"};
        private String firstChoice;
        private String secondChoice;
        private String scenarioChoice;
        private int eventCode;

        /** The constructor randomly chooses a scenario and assigns this scenario and
         *  the associated choices to scenario and choice variable
         */
        public Cinematic(){
            Random rand = new Random();
            int randomChoice = rand.nextInt(Scenario.length);
            this.scenarioChoice = Scenario[randomChoice];
            this.firstChoice = Choice1[randomChoice];
            this.secondChoice = Choice2[randomChoice];
            eventCode=0;
        }
        public Cinematic(int event){
            switch(event){
                // a unique case for each differnt special story
                case 1:
                    eventCode=event;
                    setFirstChoice("blah");
                    setSecondChoice("blah");
                    setScenarioChoice("blah");
                    break;
                default:
                    Random rand = new Random();
                    int randomChoice = rand.nextInt(Scenario.length);
                    this.scenarioChoice = Scenario[randomChoice];
                    this.firstChoice = Choice1[randomChoice];
                    this.secondChoice = Choice2[randomChoice];
                    eventCode=0;
                    break;
            }
        }

    public String getFirstChoice() {
        return firstChoice;
    }

    public void setFirstChoice(String firstChoice) {
        this.firstChoice = firstChoice;
    }

    public String getSecondChoice() {
        return secondChoice;
    }

    public void setSecondChoice(String secondChoice) {
        this.secondChoice = secondChoice;
    }

    public String getScenarioChoice() {
        return scenarioChoice;
    }

    public void setScenarioChoice(String scenarioChoice) {
        this.scenarioChoice = scenarioChoice;
    }

    public int getEventCode() {
        return eventCode;
    }
}

