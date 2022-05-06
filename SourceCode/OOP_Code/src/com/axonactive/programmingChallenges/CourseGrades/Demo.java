package com.axonactive.programmingChallenges.CourseGrades;

public class Demo {
    public static void main(String[] args) {
        CourseGrades course = new CourseGrades(4);
        GradedActivity lab = new LabActivity(70);
        PassFailExam pfExam = new PassFailExam(70);
               Essay ess = new Essay(60) ;
               FinalExam finExam = new FinalExam(80);

               course.setLab(lab);
               course.setEssay(ess);
               course.setFinalExam(finExam);
               course.setPassFailExam(pfExam);

        System.out.println(course.toString());
        System.out.println("Average : " + course.getAverage());
        System.out.println("Highest: " + course.getHighest().getScore());
        System.out.println("Lowest: " + course.getLowest().getScore());

    }
}
