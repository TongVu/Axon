package com.axonactive.programmingChallenges.problem1;

public class AgencyOne extends Agency {

    public AgencyOne() {
        super.setBasicDiscount(500000);
    }

    public AgencyOne(String id, String name, int yearCollaborated) {
        super(id, name, yearCollaborated);
        super.setBasicDiscount(500000);
        super.setDiscount();
    }

    @Override
    public String toString() {
        return "\nAgencyOne{\n" +
                super.toString() + " }";
    }
}
