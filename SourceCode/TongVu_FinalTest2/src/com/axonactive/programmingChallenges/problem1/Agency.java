package com.axonactive.programmingChallenges.problem1;

public abstract class Agency {
    private String id;
    private String name;
    private int yearCollaborated;
    private double basicComission;
    private double comission;

    public Agency() {
    }

    public Agency(String id, String name, int yearCollaborated, double basicComission) {
        this.id = id;
        this.name = name;
        this.yearCollaborated = yearCollaborated;
        this.basicComission = basicComission;
        this.comission = comission;
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

    public void setYearCollaborated(int yearCollaborated) { this.yearCollaborated = yearCollaborated; }

    public double getBasicComission() {
        return basicComission;
    }

    public void setBasicComission(double basicComission) {
        this.basicComission = basicComission;
    }

    public double getComission() {
        return comission;
    }

    public void setComission() {
        this.comission =  basicComission * yearCollaborated * 0.2;
    }

    @Override
    public String toString() {
        return "id=" + id + '\'' +
                ", name='" + name + '\'' +
                ", yearCoorperated=" + yearCollaborated +
                ", basicComission=" + basicComission +
                ", comission=" + comission + "\n";
    }
}
