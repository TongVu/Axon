package grading;

public class Grading {
    private double programming;
    private double dissertation;
    private double interview;

    public Grading(double programming, double dissertation, double interview) {
        this.programming = programming;
        this.dissertation = dissertation;
        this.interview = interview;
    }

    public double getProgramming() {
        return programming;
    }

    public void setProgramming(double programming) {
        this.programming = programming;
    }

    public double getDissertation() {
        return dissertation;
    }

    public void setDissertation(double dissertation) {
        this.dissertation = dissertation;
    }

    public double getInterview() {
        return interview;
    }

    public void setInterview(double interview) {
        this.interview = interview;
    }

    public double calculateAverage(){
        return (programming + dissertation + interview) / 3;
    }
    public String showResult(){
        if(calculateAverage() >= 90) return "A";
        if(calculateAverage() < 90 &&
            calculateAverage() >= 80) return "B";
        if(calculateAverage() < 80 &&
                calculateAverage() >= 70) return "C";
        if(calculateAverage() < 70 &&
                calculateAverage() >= 60) return "D";

        return "F";
    }
}


