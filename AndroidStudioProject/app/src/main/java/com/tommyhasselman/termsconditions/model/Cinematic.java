package com.tommyhasselman.termsconditions.model;

import java.util.Random;

/**
 * An instance of cinimatic contains a scenario and 2 related choices generated at random
 */
public class Cinematic {
    private static int eventCode;
    private String[] Choice1 = {"Pay for medication -$50", "Pay for home heating -$30", "Pay to fix the toilet -$70", "Book a psychologist appointment -$80", "Fulfill his wishes -$50", "Take your wife out to dinner -$75", "Get her phone fixed -$100", "Get a professional remove it -$75", "Hire an exterminator -$100"};
    private String[] Choice2 = {"Pray the sickness away", "Endure the cold", "Attempt to fix it yourself", "Grin and bear it", "Beat your son", "Get an earful", "Tell her to suck it up", "Attempt to clean it yourself", "Deal with your new pets"};
    private String[] Scenario = {"Your nephew is sick, do you;", "Winter is coming:", "Your toilet is broken, do you;", "Your mental health is at an all time low, do you;", "Your son asks for a new toy, do you;", "It is your wedding anniversary, do you;", "Your daughter's phone breaks, do you;", "You find suspicious mold growing in your bathroom, do you;", "Rats are found infesting your home, do you;"};
    private String firstChoice;
    private String secondChoice;
    private String scenarioChoice;
    private int [] cost = new int[3];
    private int [] randcost = {50,30,70,80};//TODO support this lazy implimentation with a test


    /**
     * The constructor randomly chooses a scenario and assigns this scenario and
     * the associated choices to scenario and choice variable
     */
    public Cinematic() {
        Random rand = new Random();
        int randomChoice = rand.nextInt(Scenario.length);
        this.scenarioChoice = Scenario[randomChoice];
        this.firstChoice = Choice1[randomChoice];
        this.secondChoice = Choice2[randomChoice];
        eventCode = randomChoice + 1;
    }

    //scenarios 1-10 are a random smatering of events
    //scenarions 11-20 are consequases of the cheapo option
    //scenarios 21-30 are conseqeuences of the pay option
    //scenario 31-40 are cheap +compassion or similar options and result in game loss
    public Cinematic(int event) {
        switch (event) {
            // a unique case for each differnt special story
            case 11:
                eventCode = event;
                setFirstChoice("Harden up and get on with work");
                setSecondChoice("Ask for time off work to attend a funeral.");
                setScenarioChoice("after a bout of pneumonia your nephew dies painfully in the night.");
                break;
            case 12:
                eventCode = event;
                setFirstChoice("See a Docter -90$");
                setSecondChoice("Tough it out like your forefathers.");
                setScenarioChoice("Two of your fingers become frostbitten.");
                cost[0]=90;
                break;
            case 13:
                eventCode = event;
                setFirstChoice("have your house professionally cleaned -150$");
                setSecondChoice("Turn to the bottle in stress -10$");
                setScenarioChoice("Your toilet overflows pouring raw sewage into your home.");
                cost[0]=150;
                cost[1]=10;
                break;
            case 14:
                eventCode = event;
                setFirstChoice("Book some leave from work.");
                setSecondChoice("Take it out on your wife and kids.");
                setScenarioChoice("Your mental health begins to spiral out of control.");
                break;
            case 21:
                eventCode = event;
                setFirstChoice("Continue working hard.");
                setSecondChoice("Go home via the bar to celebrate -5$.");
                setScenarioChoice("Your boss is impressed with your how hardy uou've been and gives you a certificate .");
                cost[1]=5;
                break;
            default:
                Random rand = new Random();
                int randomChoice = rand.nextInt(Scenario.length);
                this.scenarioChoice = Scenario[randomChoice];
                this.firstChoice = Choice1[randomChoice];
                this.secondChoice = Choice2[randomChoice];
                eventCode = randomChoice+1;
                cost[0]=randcost[eventCode];
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

    public static int getEventCode() {
        return eventCode;
    }

    public int[] getCost() {
        return cost;
    }
}

