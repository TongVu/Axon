package com.axonactive.programmingChallenges.CourseGrades;

public class LabActivity extends GradedActivity{

    public LabActivity(double score){
        super(score);
    }

    @Override
    public String toString(){

        return "Lab activity: " + getScore()
                + " _ Grade: " + getGrade();
    }
}
