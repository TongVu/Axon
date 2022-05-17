package com.axonactive.programmingChallenges.problem1;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Company com = new Company();

        com.inputCompanyInfo();
        com.inputAllAgenciesOne();
        com.inputAllAgenciesTwo();

        System.out.println("All discount from agencies one: " + com.showAllDiscountFromAgenciesOne());
        System.out.printf("All discount from agencies one: %.3f" , com.showAllBonusFromAgenciesTwo());
        System.out.println(com.showHighestDiscountFromAgenciesOne());

        System.out.printf("Total discount from all agencies: %.3f" , com.calculateDiscountFromAgenciesOneAndTwo());

        com.showThreeMostDiscountFromAllAgencies();
        com.showAllAgenciesHaveYearCollaboratedFromTenToTwentyYears();
    }
}
