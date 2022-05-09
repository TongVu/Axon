package com.axonactive.testing.junit5.projects;

import java.text.DecimalFormat;

public class InterviewGrade {
    private double programming;
    private double essay;
    private double interview;


    public void setProgramming(double programming) {
        if (programming < 0)
            throw new IllegalArgumentException("Should be larger than 0");
        else this.programming = programming;
    }

    public void setEssay(double essay) {
        if (essay < 0)
            throw new IllegalArgumentException("Should be larger than 0");
        else this.essay = essay;
    }

    public void setInterview(double interview) {
        if (interview < 0)
            throw new IllegalArgumentException("Should be larger than 0");
        this.interview = interview;
    }

    public double getInterview() {
        return interview;
    }

    public double getProgramming() {
        return programming;
    }

    public double getEssay() {
        return essay;
    }

    public double average(double programming, double essay, double interview) {
        DecimalFormat df = new DecimalFormat("0.00");
        double avg = Double.parseDouble( df.format((programming + essay + interview) / 3) );

        return avg;
    }

    public String gradingAverage(double programming, double essay, double interview) {
        double avg = average(programming, essay, interview);
        if (avg >= 90) {
            return "A";
        } else if (avg >= 80) {
            return "B";
        } else if (avg >= 70) {
            return "C";
        } else if (avg >= 60) {
            return "D";
        }

        return "F";
    }
}
