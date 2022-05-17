package com.axonactive.programmingChallenges.chapter7;

import java.util.ArrayList;
import java.util.Scanner;

public class GradeBookModification {
    static int ARRAY_SIZE = 5;

    private ArrayList<String> studentsName = new ArrayList<>(ARRAY_SIZE);
    private char[] grade = {'A', 'B', 'C', 'D', 'F'};
    private double[][] studentsTestScores = new double[5][4]; // 5 students, each of them has 4 test scores

    public GradeBookModification() {
    }

    public void setStudentName(String name) {
        studentsName.add(name);
    }

    public void setScore(int studentIndex) {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < studentsTestScores[studentIndex].length; i++) {
            System.out.print("Enter " + getStudentName(studentIndex) + "'s score: ");
            studentsTestScores[studentIndex][i] = input.nextDouble();
            while (studentsTestScores[studentIndex][i] < 0 || studentsTestScores[studentIndex][i] > 100) {
                System.out.println("The score have to be greater than 0 and less than 100. Please enter again");
                studentsTestScores[studentIndex][i] = input.nextDouble();
            }
        }
    }

    public int getArraySize(){
        return studentsName.size();
    }
    public String getStudentName(int studentIndex) {
        String results = "Not founded";

        for (int i = 0; i < studentsName.size(); i++) {
            if (studentIndex == i)
                return studentsName.get(i);
        }

        return results;
    }

    public double getAverage(int studentIndex) {
        double avg = 0.0d;
        for (int i = 0; i < studentsTestScores[studentIndex].length; i++) { // go to specific student index, loop through every scores of that student
            avg += studentsTestScores[studentIndex][i];
        }
        avg = avg / studentsTestScores[studentIndex].length;

        return avg;
    }

    public char getGrade(int studentIndex) {
        double studentAverageScore = getAverage(studentIndex);

        if (studentAverageScore >= 90 && studentAverageScore <= 100) {
            return grade[0];
        } else if (studentAverageScore >= 80 && studentAverageScore <= 89) {
            return grade[1];
        } else if (studentAverageScore >= 70 && studentAverageScore <= 79) {
            return grade[2];
        } else if (studentAverageScore >= 60 && studentAverageScore <= 69) {
            return grade[3];
        } else return grade[4];
    }

    public void dropLowest(int index) {
        studentsName.remove(index);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String studentName;
        GradeBookModification gradeListOfStudents = new GradeBookModification();

        for (int i = 0; i < ARRAY_SIZE; i++) {
            System.out.print("Enter student name: ");
            studentName = input.nextLine();
            gradeListOfStudents.setStudentName(studentName);

            System.out.println("====================================");
            gradeListOfStudents.setScore(i);
            System.out.println(""); // line break
        }

        System.out.println("============== RESULTS ===============");
        for (int i = 0; i < ARRAY_SIZE; i++) {
            System.out.println((i + 1)
                    + ".Student's name: " + gradeListOfStudents.getStudentName(i)
                    + " - AVG: " + gradeListOfStudents.getAverage(i)
                    + " - Grade: " + gradeListOfStudents.getGrade(i));
        }

        double lowest = gradeListOfStudents.getAverage(0);
        // find the lowest average
        for (int i = 1; i < ARRAY_SIZE; i++) {
            if (lowest > gradeListOfStudents.getAverage(i)) {
                lowest = gradeListOfStudents.getAverage(i);
            }
        }
        System.out.println("Lowest: " + lowest);

        // find student has the lowest point and drop him from the list
        for (int i = 0; i < gradeListOfStudents.getArraySize(); i++) {
            if (lowest == gradeListOfStudents.getAverage(i)) {
                gradeListOfStudents.dropLowest(i);
            }
        }
        System.out.println("============== AFTER REMOVE LOWEST ===============");
        for (int i = 0; i < gradeListOfStudents.getArraySize(); i++) {
            System.out.println((i + 1) + ".Student's name: " + gradeListOfStudents.getStudentName(i));
        }
    }
}
