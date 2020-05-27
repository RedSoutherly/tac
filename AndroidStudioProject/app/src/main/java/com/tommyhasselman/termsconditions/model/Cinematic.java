package com.tommyhasselman.termsconditions.model;

import java.util.Random;

public class Cinematic {
    public class Scenario{
        private String[] Choice1 = {"Pay for medication -$50", "Pay for home heating -$30", "Pay to fix the toilet -$70", "Book a psychologist appointment -$80"};
        private String[] Choice2 = {"Pray the sickness away", "Endure the cold", "Attempt to fix it yourself", "Grin and bear it"};
        private String[] Scenario = {"Your nephew is sick, do you;", "Winter is coming:", "Your toilet is broken, do you;", "Your mental health is at an all time low, do you;"};
        public String firstChoice;
        public String secondChoice;
        public String scenarioChoice;

        /** The constructor randomly chooses a scenario and assigns this scenario and
         *  the associated choices to scenario and choice variable */
        public Scenario(){
            Random rand = new Random();
            int randomChoice = rand.nextInt(Scenario.length-1);
            this.scenarioChoice = Scenario[randomChoice];
            this.firstChoice = Choice1[randomChoice];
            this.secondChoice = Choice2[randomChoice];

        }
    }

    public Cinematic(){

    }
}
