package com.axonactive.programmingChallenges.problem1;

import java.util.*;

public class Company {
    private String name;
    List<AgencyOne> listOfAgencyOne = new ArrayList<>();
    List<AgencyTwo> listOfAgencyTwo = new ArrayList<>();


    public Company() {
        AgencyOne agenOne = new AgencyOne("123", "One", 8);
        AgencyOne agenTwo = new AgencyOne("234", "Two", 10);
        AgencyOne agenThree = new AgencyOne("345", "Three", 12);
        AgencyOne agenFour = new AgencyOne("456", "Four", 15);
        listOfAgencyOne.add(agenOne);
        listOfAgencyOne.add(agenTwo);
        listOfAgencyOne.add(agenThree);
        listOfAgencyOne.add(agenFour);

        AgencyTwo agenFive = new AgencyTwo("567", "Five", 9, 1_000_000, 10_000_000);
        AgencyTwo agenSix = new AgencyTwo("678", "Six", 20, 1_200_000, 40_000_000);
        listOfAgencyTwo.add(agenFive);
        listOfAgencyTwo.add(agenSix);
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


    public void addAgencyOne() {
        System.out.println();
        Scanner input = new Scanner(System.in);

        AgencyOne newAgency = new AgencyOne();
        System.out.print("Enter agency's id: ");
        newAgency.setId(input.nextLine());

        System.out.print("Enter agency's name: ");
        newAgency.setName(input.nextLine());

        int yearsCollaborated = 0;
        do {
            if(yearsCollaborated < 0) System.out.println("Year collaborated at least is 0");
            System.out.print("Enter year collaborated: ");
            yearsCollaborated = input.nextInt();
            input.nextLine();
            newAgency.setYearCollaborated(yearsCollaborated);
        } while (yearsCollaborated < 0);

        listOfAgencyOne.add(newAgency);
    }

    public void addAgencyTwo() {
        System.out.println();
        Scanner input = new Scanner(System.in);

        AgencyTwo newAgency = new AgencyTwo();
        System.out.print("Enter agency's id: ");
        newAgency.setId(input.nextLine());

        System.out.print("Enter agency's name: ");
        newAgency.setName(input.nextLine());

        int yearsCollaborated = 0;
        do {
            if(yearsCollaborated < 0) System.out.println("Year collaborated at least is 0");
            System.out.print("Enter year collaborated: ");
            yearsCollaborated = input.nextInt();
            input.nextLine();
            newAgency.setYearCollaborated(yearsCollaborated);
        } while (yearsCollaborated < 0);

        double basicDiscount = 0;

        do {
            if(basicDiscount < 0) System.out.println("Basic discount have to be greater than 0");
            System.out.print("Enter basic discount: ");
            basicDiscount = input.nextDouble();
            input.nextLine();
            newAgency.setBasicDiscount(basicDiscount);
        } while (basicDiscount < 0);


        double salesFigure = 0;
        do {
            if(salesFigure < 0) System.out.println("Sales figure is a positive number");
            System.out.print("Enter sales figures: ");
            salesFigure = input.nextDouble();
            input.nextLine();
            newAgency.setSalesFigure(salesFigure);
        } while (salesFigure < 0);

        listOfAgencyTwo.add(newAgency);
    }

    public void inputAllAgenciesOne(){
        System.out.println("====================== ADD AGENCIES ONE ======================");
        Scanner input = new Scanner(System.in);
        int numberOfAgency = 0;

        do {
            if(numberOfAgency < 0) System.out.println("Number of agency need to be a positive number");
            System.out.print("Input number of agency one: ");
            numberOfAgency = input.nextInt();
        } while(numberOfAgency < 0);


        for (int i = 0; i < numberOfAgency; i++) {
            System.out.println("Agency number " + (i + 1));
            addAgencyOne();
        }
    }

    public void inputAllAgenciesTwo(){
        System.out.println("====================== ADD AGENCIES TWO ======================");
        Scanner input = new Scanner(System.in);
        int numberOfAgency = 0;

        do {
            if(numberOfAgency < 0) System.out.println("Number of agency need to be a positive number");
            System.out.print("Input number of agency two: ");
            numberOfAgency = input.nextInt();
        } while(numberOfAgency < 0);


        for (int i = 0; i < numberOfAgency; i++) {
            System.out.println("Agency number " + (i + 1));
            addAgencyTwo();
        }
    }

    public double showAllDiscountFromAgenciesOne(){
        double totalDiscount = 0;
        for (AgencyOne agency: listOfAgencyOne)
            totalDiscount = +agency.getDiscount();

        return totalDiscount;
    }

    public double showAllBonusFromAgenciesTwo(){
        double totalBonus = 0;
        for (AgencyTwo agency : listOfAgencyTwo)
            totalBonus += agency.getBonus();

        return totalBonus;
    }

    public AgencyOne showHighestDiscountFromAgenciesOne(){
        double max = listOfAgencyOne.get(0).getDiscount();
        AgencyOne highestDiscountedAgency = new AgencyOne();
        for (AgencyOne agency :
                listOfAgencyOne) {
            if (max < agency.getDiscount()) {
                max = agency.getDiscount();
                highestDiscountedAgency = agency;
            }
        }

        return highestDiscountedAgency;
    }

    public double calculateDiscountFromAgenciesOneAndTwo(){
        double totalDiscount = 0;

        for (AgencyOne agen : listOfAgencyOne)
            totalDiscount += agen.getDiscount();

        for (AgencyTwo agen : listOfAgencyTwo)
            totalDiscount += agen.getDiscount();

        return totalDiscount;
    }

    public void showThreeMostDiscountFromAllAgencies(){
        System.out.println("=================== THREE MOST DISCOUNTED AGENCIES");
        List<Double> discountList = new ArrayList<>();

        for (AgencyOne agency: listOfAgencyOne) {
            discountList.add(agency.getDiscount());
        }
        for (AgencyTwo agency : listOfAgencyTwo) {
            discountList.add(agency.getDiscount());
        }

        Collections.reverse(discountList);

        for (int i = 0;
             i < (discountList.size() > 3 ? 3 : discountList.size())
                ; i++) {
            for (int j = 0; j < listOfAgencyOne.size(); j++) {
                if(discountList.get(i) == listOfAgencyOne.get(j).getDiscount()){
                    System.out.println(listOfAgencyOne.get(j));
                }
            }
            for (int j = 0; j < listOfAgencyTwo.size(); j++) {
                if(discountList.get(i) == listOfAgencyTwo.get(j).getDiscount()){
                    System.out.println(listOfAgencyTwo.get(j));
                }
            }
        }
    }

    public void showAllAgenciesHaveYearCollaboratedFromTenToTwentyYears(){
        System.out.println("=================== LIST OF AGENCY ONE'VE BEEN COLLABORATING FROM 10 TO 20 YEARS");
        for (AgencyOne agen : listOfAgencyOne) {
            if(agen.getYearCollaborated() >= 10 &&
                agen.getYearCollaborated() <= 20) System.out.println(agen);

        }

        System.out.println("=================== LIST OF AGENCY TWO'VE BEEN COLLABORATING FROM 10 TO 20 YEARS");
        for (AgencyTwo agen : listOfAgencyTwo) {
            if(agen.getYearCollaborated() >= 10 &&
                    agen.getYearCollaborated() <= 20) System.out.println(agen);

        }
    }
}
