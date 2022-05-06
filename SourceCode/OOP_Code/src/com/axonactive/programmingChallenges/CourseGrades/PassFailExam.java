package com.axonactive.programmingChallenges.CourseGrades;

public class PassFailExam extends GradedActivity{
    public PassFailExam(double s){
        super(s);
    }

    @Override
    public String toString(){

        return "PassFail exam: " + getScore()
                + " _ Grade: " + getGrade();
    }
}
