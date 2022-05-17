package com.axonactive.testing.junit5.projects;

import java.util.NoSuchElementException;

public class CattlesFodder {
    private String foodGrade;

    public String getFoodGrade() {
        return foodGrade;
    }

    public void setFoodGrade(String foodGrade) {
        this.foodGrade = foodGrade;
    }

    public int checkGrade(){
        if(getFoodGrade().equals("A")) return 30;
        else if(getFoodGrade().equals("B")) return 20;
        else if(getFoodGrade().equals("C")) return 10;
        else
            throw new NoSuchElementException("There is no such grade");
    }
}
