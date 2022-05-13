package com.axonactive.programmingChallenges.problem1;

public abstract class Agency {
    private String id;
    private String name;
    private int yearCollaborated;
    private double basicDiscount;
    private double discount;

    public Agency(String id, String name, int yearCollaborated, double basicDiscount) {
        this.id = id;
        this.name = name;
        this.yearCollaborated = yearCollaborated;
        this.basicDiscount = basicDiscount;
        this.discount = basicDiscount * yearCollaborated * 0.2;
    }

    public Agency() {
    }

    public Agency(String id, String name, int yearCollaborated) {
        this.id = id;
        this.name = name;
        this.yearCollaborated = yearCollaborated;
        this.discount = basicDiscount * yearCollaborated * 0.2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearCollaborated() {
        return yearCollaborated;
    }

    public void setYearCollaborated(int yearCollaborated) {
        this.yearCollaborated = yearCollaborated;
    }

    public double getBasicDiscount() {
        return basicDiscount;
    }

    public void setBasicDiscount(double basicDiscount) {
        this.basicDiscount = basicDiscount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount() {
        this.discount = basicDiscount * yearCollaborated * 0.2;
    }



    @Override
    public String toString() {
        return "id = " + id + '\n' +
                "name = " + name + '\n' +
                "yearCollaborated = " + yearCollaborated + "\n"+
                "discount = " + discount ;
    }
}
