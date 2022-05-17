package com.axonactive.programmingChallenges.chapter6;


public class Procedure {
    String procedureName, datePerform, practioner;
    double charge;

    public Procedure(){}
    public Procedure(String procedureName, String datePerform) {
        this.procedureName = procedureName;
        this.datePerform = datePerform;
    }

    public Procedure(String practioner, double charge) {
        this.practioner = practioner;
        this.charge = charge;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public void setDatePerform(String datePerform) {
        this.datePerform = datePerform;
    }

    public void setPractioner(String practioner) {
        this.practioner = practioner;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public String getDatePerform() {
        return datePerform;
    }

    public String getPractioner() {
        return practioner;
    }

    public double getCharge() {
        return charge;
    }
}
