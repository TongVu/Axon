package com.axonactive.programmingChallenges.CourseGrades;

public class FinalExam extends GradedActivity{
    public FinalExam(double s){
       super(s);
    }

    @Override
    public String toString(){

        return "Final exam: " + getScore()
                + " _ Grade: " + getGrade();
    }
}
