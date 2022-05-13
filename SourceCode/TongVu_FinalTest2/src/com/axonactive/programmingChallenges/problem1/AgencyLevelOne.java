package com.axonactive.programmingChallenges.problem1;

public class AgencyLevelOne extends Agency {
    private double basicComission = 500_000.0;

    public AgencyLevelOne() {
        super();
    }

    public AgencyLevelOne(String id, String name, int year, int basicComission) {
        super(id, name, year, basicComission);
    }

    @Override
    public double getBasicComission() {
        return basicComission;
    }


    @Override
    public String toString() {
        return "Dlc1{" +
                super.toString() +
                "basicComission=" + basicComission +
                '}';
    }
}
