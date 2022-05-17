package com.axonactive.programmingChallenges.CourseGrades;

public class CourseGrades implements Analyzable{
    private GradedActivity[] grades;

    public CourseGrades(int numb) {
        this.grades = new GradedActivity[numb];

        for (int i = 0; i < numb; i++) {
            grades[i] = new GradedActivity();
        }
    }

    public void setLab(GradedActivity obj) {
        grades[0] = new LabActivity(obj.getScore());
    }

    public void setPassFailExam(PassFailExam obj){
        grades[1] = new PassFailExam(obj.getScore());
    }

    public void setEssay(Essay obj){
        grades[2] = new Essay(obj.getScore());
    }

    public void setFinalExam(FinalExam obj){
        grades[3] = new FinalExam(obj.getScore());
    }

    @Override
    public String toString(){
        return grades[0].toString() + "\n"  +
                grades[1].toString() + "\n"  +
                grades[2].toString() + "\n"  +
                grades[3].toString();
    }

    public double getAverage(){
        return (grades[0].getScore() +
                grades[1].getScore() +
                grades[2].getScore() +
                grades[3].getScore()) / 4;
    }

    public GradedActivity getHighest(){
        GradedActivity obj = new GradedActivity();
        obj.setScore(grades[0].getScore());

        for (int i = 1; i < grades.length; i++) {
            if(obj.getScore() < grades[i].getScore())
                obj.setScore(grades[i].getScore());
        }

        return obj;
    }

    public GradedActivity getLowest(){
        GradedActivity obj = new GradedActivity();
        obj.setScore(grades[0].getScore());

        for (int i = 1; i < grades.length; i++) {
            if(obj.getScore() > grades[i].getScore())
                obj.setScore(grades[i].getScore());
        }

        return obj;
    }
}
