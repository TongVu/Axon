package com.axonactive.programmingChallenges.ShiftSupervisor;


public class ShiftSupervisorDemo {

    public ShiftSupervisorDemo(String[] args) {
        ShiftSupervisor boss = new ShiftSupervisor(
                "Mr.Liem", "999-L", "04 Apr 2022");

        boss.setSalary(5000);
        boss.setYearlyBonus(15000);
        boss.getInfo();
    }
}
