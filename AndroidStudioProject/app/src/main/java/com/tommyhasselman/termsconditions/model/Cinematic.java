package com.tommyhasselman.termsconditions.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;


/**
 * An instance of cinimatic contains a scenario and 2 related choices generated at random
 */
public class Cinematic implements Serializable {
    private int eventCode;
    private static ArrayList<Integer> randChoice=new ArrayList<Integer>();
    private String[] Choice1 = {"Pay for medication -$50", "Pay for home heating -$30", "Pay to fix the toilet -$70", "Book a psychologist appointment -$80", "Fulfill his wishes -$50", "Take your wife out to dinner -$75", "Get her phone fixed -$100", "Get a professional remove it -$75", "Hire an exterminator -$100"};
    private String[] Choice2 = {"Pray the sickness away", "Endure the cold", "Attempt to fix it yourself", "Grin and bear it", "Beat your son", "Get an earful", "Tell her to suck it up", "Attempt to clean it yourself", "Deal with your new pets"};
    private String[] Scenario = {"Your nephew is sick, do you;", "Winter is coming:", "Your toilet is broken, do you;", "Your mental health is at an all time low, do you;", "Your son asks for a new toy, do you;", "It is your wedding anniversary, do you;", "Your daughter's phone breaks, do you;", "You find suspicious mold growing in your bathroom, do you;", "Rats are found infesting your home, do you;"};
    private String firstChoice;
    private String secondChoice;
    private String scenarioChoice;
    private int [] cost = new int[3];
    private int [] randcost = {50,30,70,80,50,75,100,75,100};//TODO support this lazy implimentation with a test


    /**
     * The constructor randomly chooses a scenario and assigns this scenario and
     * the associated choices to scenario and choice variable
     */
    public Cinematic() {
        if(randChoice.size()==0){
            for(int i=0;i<9;i++){
                randChoice.add(i);
            }
        }
        Collections.sort(randChoice);
        int rand = randChoice.get(0);
        randChoice.remove(0);
        this.scenarioChoice = Scenario[rand];
        this.firstChoice = Choice1[rand];
        this.secondChoice = Choice2[rand];
        this.eventCode = rand;
        this.cost[0]=randcost[rand];
        System.out.println(rand +" "+ this.scenarioChoice);
    }

    //scenarios 0-9 are a random smatering of events
    //scenarions 10-19 are consequases of the cheapo option
    //scenarios 21-30 are conseqeuences of the pay option
    //scenario 31-40 are cheap +compassion or similar options and result in game loss
    public Cinematic(int event) {
        System.out.println("switch "+ event);
        switch (event) {

            // a unique case for each differnt special story
            case 10:
                this.eventCode = event;
                this.setFirstChoice("Harden up and get on with work");
                this.setSecondChoice("Ask for time off work to attend a funeral.");
                this.setScenarioChoice("after a bout of pneumonia your nephew dies painfully in the night.");
                break;
            case 11:
                this.eventCode = event;
                this.setFirstChoice("See a Docter -90$");
                this.setSecondChoice("Tough it out like your forefathers.");
                this.setScenarioChoice("Two of your fingers become frostbitten.");
                this.cost[0]=90;
                break;
            case 12:
                this.eventCode = event;
                this.setFirstChoice("have your house professionally cleaned -150$");
                this.setSecondChoice("Turn to the bottle in stress -10$");
                this.setScenarioChoice("Your toilet overflows pouring raw sewage into your home.");
                this.cost[0]=150;
                this.cost[1]=10;
                break;
            case 13:
                this.eventCode = event;
                this.setFirstChoice("Book some leave from work.");
                this.setSecondChoice("Take it out on your wife and kids.");
                this.setScenarioChoice("Your mental health begins to spiral out of control.");
                break;
            case 20:
                this.eventCode = event;
                this.setFirstChoice("Continue working hard.");
                this.setSecondChoice("Go home via the bar to celebrate -5$.");
                this.setScenarioChoice("Your boss is impressed with your how hardy uou've been and gives you a certificate .");
                this.cost[1]=5;
                break;
            default:
                if(randChoice.size()==0){
                    for(int i=0;i<9;i++){
                        randChoice.add(i);
                    }
                }
                Collections.sort(randChoice);
                int rand = randChoice.get(0);
                randChoice.remove(0);
                this.scenarioChoice = Scenario[rand];
                this.firstChoice = Choice1[rand];
                this.secondChoice = Choice2[rand];
                this.eventCode = rand;
                this.cost[0]=randcost[eventCode];
                System.out.println("default");
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

    public int[] getCost() {
        return cost;
    }
}

