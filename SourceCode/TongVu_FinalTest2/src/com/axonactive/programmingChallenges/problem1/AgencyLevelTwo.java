package com.axonactive.programmingChallenges.problem1;

public class AgencyLevelTwo extends Agency {
    private double sales;
    private double bonus;

    public AgencyLevelTwo(String id, String name, int year, double basicComission, double sales){
        super(id, name, year, basicComission);
        this.sales = sales;
        setBonus();
    }
    public AgencyLevelTwo(double sales, double bonus) {
        this.sales = sales;
        this.bonus = bonus;
    }

    public AgencyLevelTwo() {
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus() {
       if(sales >= 50_000_000.0)
           this.bonus = 0.3 * sales;

       else if( 20_000_000.0<= bonus &&
               bonus < 50_000_000.0)
           this.bonus = 0.15 * sales;

       else this.bonus = 0.05 * sales;
    }


    @Override
    public String toString() {
        return "Dlc2{" +
                super.toString() +
                "sales=" + sales +
                ", bonus=" + bonus +
                '}';
    }
}
