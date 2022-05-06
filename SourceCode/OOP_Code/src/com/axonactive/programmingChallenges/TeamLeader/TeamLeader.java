package com.axonactive.programmingChallenges.TeamLeader;
import com.axonactive.programmingChallenges.EmployeeAndProductionWorker.ProductionWorker;

/*
A team leader is an hourly paid production worker that leads a small team

/TeamLeader extends ProductionWorker

/Fields:
    -monthlyBonus
    -trainingHoursRequired
    -trainingHoursAttended

/Methods:
    +announceHours
 */

public class TeamLeader extends ProductionWorker{
    private double monthlyBonus;
    private double trainingHoursRequired;
    private double trainingHoursAttended;

    public TeamLeader(){
        super();
    }

    public TeamLeader(String name, String empNumber, String hireDate){
        super(name, empNumber, hireDate);
    }

    public double getMonthlyBonus() {
        return monthlyBonus;
    }

    public void setMonthlyBonus(double monthlyBonus) {
        this.monthlyBonus = monthlyBonus;
    }

    public double getTrainingHoursRequired() {
        return trainingHoursRequired;
    }

    public void setTrainingHoursRequired(double trainingHoursRequired) {
        this.trainingHoursRequired = trainingHoursRequired;
    }

    public double getTrainingHoursAttended() {
        return trainingHoursAttended;
    }

    public void setTrainingHoursAttended(double trainingHoursAttended) {
        this.trainingHoursAttended = trainingHoursAttended;
    }

    public void announceHours(){
        if(getTrainingHoursRequired() - getTrainingHoursAttended() > 0 )
            System.out.println("You need attend " +
                    (getTrainingHoursRequired() - getTrainingHoursAttended() ) +
                    " hours more");
        else System.out.println("Congratulation, you've met the attended hours required");
    }

    @Override
    public void getInfo(){
        System.out.println("Name: " + getName());
        System.out.println("ID: " + getEmployeeNumber());
        System.out.println("Hire date: " + getHireDate());
        System.out.println("Shift: " + getShift());
        System.out.println("Pay rate: " + getPayRate());
        System.out.println("Training hours attended: " + getTrainingHoursAttended());
        System.out.println("Training hours required: " + getTrainingHoursRequired());
    }
}
