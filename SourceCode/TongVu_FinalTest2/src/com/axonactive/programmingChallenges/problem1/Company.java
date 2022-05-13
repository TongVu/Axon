package com.axonactive.programmingChallenges.problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Company {
    private String name;
    List<AgencyLevelOne> listOfAllDlc1 = new ArrayList<>();
    List<AgencyLevelTwo> listOfAllDlc2 = new ArrayList<>();

    public Company() {
        AgencyLevelOne agen1 = new AgencyLevelOne("123", "one", 12, 500000);
        AgencyLevelOne agen2 = new AgencyLevelOne("343", "two", 8, 500000);
        AgencyLevelOne agen3 = new AgencyLevelOne("456", "three", 07, 500000);

        agen1.setComission();
        agen2.setComission();
        agen3.setComission();

        listOfAllDlc1.add(agen1);
        listOfAllDlc1.add(agen2);
        listOfAllDlc1.add(agen3);

        AgencyLevelTwo agen4 = new AgencyLevelTwo("789", "four", 12, 1200000, 50000000d );
        AgencyLevelTwo agen5 = new AgencyLevelTwo("451", "five", 20, 1200000, 12000000d );
        AgencyLevelTwo agen6 = new AgencyLevelTwo("124", "six", 21, 1200000, 450000000d );

        agen4.setBonus();
        agen5.setBonus();
        agen6.setBonus();

        listOfAllDlc2.add(agen4);
        listOfAllDlc2.add(agen5);
        listOfAllDlc2.add(agen6);
    }

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void inputCompanyInfo() {
        Scanner input = new Scanner(System.in);
        System.out.print("Input company name: ");
        setName(input.nextLine());
    }

    public void inputDlc1() {
        Scanner input = new Scanner(System.in);
        AgencyLevelOne newDlc1 = new AgencyLevelOne();

        System.out.print("Input agency id: ");
        newDlc1.setId(input.nextLine());

        System.out.print("Input agency name: ");
        newDlc1.setName(input.nextLine());

        int year;
        do {
            System.out.print("Input year coorperated (postitive number): ");
            year = input.nextInt();
            newDlc1.setYearCollaborated(year);
            input.nextLine();
        } while (year <= 0);

        newDlc1.setComission();
        listOfAllDlc1.add(newDlc1);
    }

    public void inputDlc2() {
        Scanner input = new Scanner(System.in);
        AgencyLevelTwo newDlc2 = new AgencyLevelTwo();

        System.out.print("Input agency id: ");
        newDlc2.setId(input.nextLine());

        System.out.print("Input agency name: ");
        newDlc2.setName(input.nextLine());

        int year;
        do {
            System.out.print("Input year coorperated (postitive number): ");
            year = input.nextInt();
            newDlc2.setYearCollaborated(year);
            input.nextLine();
        } while (year <= 0);

        double basicComission = 0;
        do {
            System.out.print("Input basic comission (positive number): ");
            basicComission = input.nextDouble();
            newDlc2.setBasicComission(basicComission);
            input.nextLine();
        } while (basicComission <= 0);

        newDlc2.setComission();
        newDlc2.setBonus();
        listOfAllDlc2.add(newDlc2);
    }

    public void inputAllDlc1() {
        Scanner input = new Scanner(System.in);
        int numberOfAgencies;

        do {
            System.out.print("Input number of agency level 1: ");
            numberOfAgencies = input.nextInt();
        } while (numberOfAgencies < 0);

        for (int i = 0; i < numberOfAgencies; i++) {
            System.out.println("AGENCY " + (i + 1));
            inputDlc1();
        }
    }

    public void inputAllDlc2() {
        Scanner input = new Scanner(System.in);
        int numberOfAgencies;

        do {
            System.out.print("Input number of agency level 2: ");
            numberOfAgencies = input.nextInt();
        } while (numberOfAgencies < 0);

        for (int i = 0; i < numberOfAgencies; i++) {
            System.out.println("AGENCY " + (i + 1));
            inputDlc2();
        }
    }

    public double showTotalComissionOfAllDlc1() {
        System.out.println("===========================================");
        double totalComission = 0;

        for (AgencyLevelOne agency : listOfAllDlc1) {
            totalComission += agency.getComission();
        }
        return totalComission;
    }

    public double showTotalBonusOfAllDlc2() {
        System.out.println("===========================================");
        double totalBonus = 0;

        for (AgencyLevelTwo agency : listOfAllDlc2) {
            totalBonus += agency.getBonus();
        }

        return totalBonus;
    }

    public double showHighestComissionOfDlc1() {
        System.out.println("===========================================");
        double max = 0;
        for (AgencyLevelOne agency :
                listOfAllDlc1) {
            if (agency.getComission() > max) max = agency.getBasicComission();
        }
        return max;
    }

    public double calculateTotalComissionOfAllDlc1AndDlc2() {
        System.out.println("===========================================");
        double totalComissionOfAllAgencies = 0;
        // calculate total for all dlc1
        for (AgencyLevelOne agency :
                listOfAllDlc1) {
            totalComissionOfAllAgencies += agency.getComission();
        }

        // calculate total for all dlc2
        for (AgencyLevelTwo agency :
                listOfAllDlc2) {
            totalComissionOfAllAgencies += agency.getComission();
        }

        return totalComissionOfAllAgencies;
    }

    public void showInfoOfThreeDlHasHighestComission() {
        System.out.println("===========================================");
        List<AgencyLevelOne> dupListOfAllDlc1 = new ArrayList<>();
        dupListOfAllDlc1.addAll(listOfAllDlc1);

        List<AgencyLevelOne> threeHighestOfAgency1 = new ArrayList<>();
        double firstListOne = dupListOfAllDlc1.get(0).getComission(),
                secondListOne = dupListOfAllDlc1.get(0).getComission(),
                thirdListOne = dupListOfAllDlc1.get(0).getComission();

        //find max, add to list highest, delete that agency, repeat
        for (int i = 0; i < 3; i++) {
            for (AgencyLevelOne agency : dupListOfAllDlc1) {
                if (firstListOne < agency.getComission()) firstListOne = agency.getComission(); // found max
            }
            for (AgencyLevelOne agency: dupListOfAllDlc1) {
                if(secondListOne < agency.getComission() &&
                        agency.getComission() != firstListOne){
                    secondListOne = agency.getComission();
                }
            }

            for (AgencyLevelOne agency: dupListOfAllDlc1) {
                if(thirdListOne < agency.getComission() &&
                        agency.getComission() != firstListOne &&
                        agency.getComission() != secondListOne){
                    thirdListOne = agency.getComission();
                }
            }
        }

        List<AgencyLevelTwo> dupListOfAllDlc2 = new ArrayList<>(listOfAllDlc2);
        double firstListTwo = dupListOfAllDlc2.get(0).getComission(),
                secondListTwo = dupListOfAllDlc2.get(0).getComission(),
                thirdListTwo = dupListOfAllDlc2.get(0).getComission();

        for (int i = 0; i < 3; i++) {
            for (AgencyLevelTwo agency : dupListOfAllDlc2) {
                if (firstListTwo < agency.getComission()) firstListTwo = agency.getComission(); // found max
            }
            for (AgencyLevelTwo agency: dupListOfAllDlc2) {
                if(secondListTwo < agency.getComission() &&
                        agency.getComission() != firstListTwo){
                    secondListTwo = agency.getComission();
                }
            }

            for (AgencyLevelTwo agency: dupListOfAllDlc2) {
                if(thirdListTwo < agency.getComission() &&
                        agency.getComission() != firstListTwo &&
                        agency.getComission() != secondListTwo){
                    thirdListTwo = agency.getComission();
                }
            }
        }

        List<Agency> highestCommissionFromAgencies = new ArrayList<>();

        for (AgencyLevelOne agen : listOfAllDlc1) {
            if(agen.getComission() == firstListOne) highestCommissionFromAgencies.add(agen);

            if(agen.getComission() == secondListOne) highestCommissionFromAgencies.add(agen);

            if(agen.getComission() == thirdListOne) highestCommissionFromAgencies.add(agen);
        }

        for (AgencyLevelTwo agen : listOfAllDlc2) {
            if(agen.getComission() == firstListTwo) highestCommissionFromAgencies.add(agen);

            if(agen.getComission() == secondListTwo) highestCommissionFromAgencies.add(agen);

            if(agen.getComission() == thirdListTwo) highestCommissionFromAgencies.add(agen);
        }
    }

    public List<Agency> showListOfAllDlCoorperatedFromTenToTwentyYear() {
        System.out.println("===========================================");
        List<Agency> listOfAgencyFromTenToTwentyYear = null;

        for (AgencyLevelOne agency :
                listOfAllDlc1) {
            if (agency.getYearCollaborated() >= 10 &&
                    agency.getYearCollaborated() <= 20) {
                listOfAgencyFromTenToTwentyYear.add(agency);
            }
        }
        for (AgencyLevelTwo agency :
                listOfAllDlc2) {
            if (agency.getYearCollaborated() >= 10 &&
                    agency.getYearCollaborated() <= 20) {
                listOfAgencyFromTenToTwentyYear.add(agency);
            }
        }

        return listOfAgencyFromTenToTwentyYear;
    }
}
