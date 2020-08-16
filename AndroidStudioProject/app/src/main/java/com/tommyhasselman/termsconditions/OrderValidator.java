package com.tommyhasselman.termsconditions;

/**
 * the order validator class offloads the logic of validating boxes and orders as correct or
 * incorrect. this is important as the complexity will balloon somehwhat when multiple gameplay
 *rules are implimented
 */
@SuppressWarnings("unused")
public class OrderValidator {
    private int rules;

    public void incrementRules(){
        rules++;
    }

    /**
     * this method is essectially just a swithc to call the correct version of the games logic
     * this implimentation is likely to lead to duplication of code but avoids large
     * hard to test branching if statements that become a behemoth to read
     * @return boolean valid returns true if by current rules a box matchs an order
     */
    public boolean validateBox(){
        switch(rules) {
            case (1):
                return validateOne();

            default:
                //if box = order
                //return true
                //else
                return false;
        }
    }

    /**
     * the template for a given validate method given a set of rules called from the switch
     * statement
     * @return valid where true if box == order given a unique defition of ==
     */
    public boolean validateOne(){
        //if box = order ++ some set of rules
        //return true
        //else
        return false;
    }
    public OrderValidator(int rules){
        if(rules>5){//5 is arbitrary at this point
            this.rules=0;
        }
        this.rules=rules;
    }

}
