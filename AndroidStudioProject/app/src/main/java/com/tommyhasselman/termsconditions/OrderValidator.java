package com.tommyhasselman.termsconditions;

public class OrderValidator {
    private int rules;

    public void incrementRules(){
        rules++;
    }
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
    public boolean validateOne(){
        //if box = order ++ some set of rules
        //return true
        //else
        return false;
    }
    public OrderValidator(int rules){
        if(rules>5){//5 is arbitrry at this point
            this.rules=0;
        }
        this.rules=rules;
    }

}
