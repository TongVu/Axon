package com.axonactive.programmingChallenges.problem1;

public class AgencyTwo extends Agency {
    private double salesFigure;
    private double bonus;
    private double commission;

    public AgencyTwo(String id, String name, int yearCollaborated, double basicDiscount, double salesFigure) {
        super(id, name, yearCollaborated, basicDiscount);
        this.salesFigure = salesFigure;
        setCommission();
        this.bonus = getDiscount() + this.commission;
    }


    public AgencyTwo() {
    }

    public double getSalesFigure() {
        return salesFigure;
    }

    public void setSalesFigure(double salesFigure) {
        this.salesFigure = salesFigure;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission() {
        if(salesFigure >= 50_000_000d) this.commission = 0.3 * salesFigure;
        else if(salesFigure < 50_000_000d &&
                salesFigure >= 20_000_000d) this.commission = 0.15 * salesFigure;
        else this.commission = 0.05 * salesFigure;
    }

    @Override
    public String toString() {
        return "\nAgencyTwo{\n" +
                super.toString() + "\n" +
                "salesFigure=" + salesFigure + "\n" +
                "bonus=" + bonus + "\n" +
                "commission=" + commission + " }";
    }
}
