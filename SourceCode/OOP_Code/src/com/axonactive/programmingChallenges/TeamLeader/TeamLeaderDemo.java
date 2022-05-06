package com.axonactive.programmingChallenges.TeamLeader;

public class TeamLeaderDemo {

    public static void main(String[] args) {
        TeamLeader tv = new TeamLeader("A", "123-H", "04 Apr 2022");

        tv.setPayRate(20);
        tv.setShift(2);
        tv.setMonthlyBonus(2000);
        tv.setTrainingHoursRequired(250);
        tv.setTrainingHoursAttended(200);
        tv.getInfo();
        tv.announceHours();
    }
}
