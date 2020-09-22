package com.tommyhasselman.termsconditions.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;


/**
 * An instance of cinematic contains a scenario and 2 related choices generated at random
 */
public class Cinematic implements Serializable {
    private int eventCode;
    private static ArrayList<Integer> randChoice= new ArrayList<>();
    private String[] Choice1 = {"Pay for medication -$50", "Pay for home heating -$30", "Pay to fix the toilet -$70", "Book a psychologist appointment -$80", "Fulfill his wishes -$50", "Take your wife out to dinner -$75", "Get her phone fixed -$100", "Get a professional remove it -$75", "Hire an exterminator -$100"};
    private String[] Choice2 = {"Pray the sickness away", "Endure the cold", "Attempt to fix it yourself", "Grin and bear it", "Beat your son", "Get an earful", "Tell her to suck it up", "Attempt to clean it yourself", "Deal with your new pets"};
    private String[] Scenario = {"Your nephew is sick, do you;", "Winter is coming:", "Your toilet is broken, do you;", "Your mental health is at an all time low, do you;", "Your son asks for a new toy, do you;", "It is your wedding anniversary, do you;", "Your daughter's phone breaks, do you;", "You find suspicious mold growing in your bathroom, do you;", "Rats are found infesting your home, do you;"};
    private String firstChoice;
    private String secondChoice;
    private String scenarioChoice;
    private int [] cost = new int[3];
    private int [] randcost = {50,30,70,80,50,75,100,75,100};//TODO support this lazy implementation with a test


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
                this.setFirstChoice("See a Doctor -90$");
                this.setSecondChoice("Tough it out like your forefathers.");
                this.setScenarioChoice("Two of your fingers become frostbitten.");
                this.cost[0]=90;
                break;
            case 12:
                this.eventCode = event;
                this.setFirstChoice("Have your house professionally cleaned -150$");
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
            case 14:
                this.eventCode = event;
                this.setFirstChoice("Bribe the inspector -100$.");
                this.setSecondChoice("Say goodbye to your son .");
                this.setScenarioChoice("child protection hear about you beating your son from his school.");
                this.cost[0]=100;
                break;
            case 20:
                this.eventCode = event;
                this.setFirstChoice("Continue working hard.");
                this.setSecondChoice("Go home via the bar to celebrate -5$.");
                this.setScenarioChoice("Your boss is impressed with your how hardy you've been and gives you a certificate .");
                this.cost[1]=5;
                break;
            case 21:
                this.eventCode = event;
                this.setFirstChoice("Have your buddy do it .");
                this.setSecondChoice("Have a doctor do it  -50$.");
                this.setScenarioChoice("Your frostbitten fingers need amputating  .");
                this.cost[1]=50;
                break;
            case 22:
                this.eventCode = event;
                this.setFirstChoice("Lie about having it cleaned .");
                this.setSecondChoice("Pay up 200$.");
                this.setScenarioChoice("Your landlord inspects and insists you pay for cleaning.");
                this.cost[1]=200;
                break;
            case 30:
                this.eventCode = event;
                this.setFirstChoice("Pay a defense lawyer -350$");
                this.setSecondChoice("Pay the owner of the bar you trashed -300$.");
                this.setScenarioChoice("After days of hard work bottling your feelings up you go on a drink fueled rage.");
                this.cost[0]=350;
                this.cost[1]=300;
                break;
            case 31:
                this.eventCode = event;
                this.setFirstChoice("Numb the pain and fever with more medication -80$");
                this.setSecondChoice("Take the day off and ask your cousin to cover for you -100$.");
                this.setScenarioChoice("Your finger stubs get infected and you have to buy antibiotics -40$.");
                this.cost[0]=80;
                this.cost[1]=100;
                this.cost[2]=40;
                break;
            case 32:
                this.eventCode = event;
                this.setFirstChoice("Stay in the red motel 300$.");
                this.setSecondChoice("Stay in the blue motel 300$.");
                this.setScenarioChoice("Your landlord catches you in your cleaning lie and kicks you out");
                this.cost[1]=200;
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

