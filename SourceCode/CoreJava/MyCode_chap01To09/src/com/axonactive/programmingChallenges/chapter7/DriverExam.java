package com.axonactive.programmingChallenges.chapter7;

import java.util.ArrayList;

public class DriverExam {
    private final String[] correctAnswers = {
            "B", "D", "A", "A", "C",
            "A", "B", "A", "C", "D",
            "B", "C", "D", "A", "D",
            "C", "C", "B", "D", "A"
    };
    private final int NUMBER_OF_QUESTIONS = 20;

    public DriverExam() {
    }

    public boolean passed(String[] answers) {
        if (totalCorrect(answers) >= 15)
            return true;

        return false;
    }

    ;

    public int totalCorrect(String[] answers) {
        int totalCorrect = 0;
        for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
            if(answers[i].equalsIgnoreCase(correctAnswers[i])){
                totalCorrect++;
            }
        }

        return totalCorrect;
    }

    public int totalIncorrect(String[] answers) {
        int totalIncorrect = 0;
        for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
            if(!answers[i].equalsIgnoreCase(correctAnswers[i])){
               totalIncorrect++;
            }
        }

        return totalIncorrect;
    }

    public ArrayList<String> questionsMissed(String[] answers) {
        ArrayList<String> missedList = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
            if(!answers[i].equalsIgnoreCase(correctAnswers[i])){
                missedList.add(answers[i]);
            }
        }
        return missedList;
    }
}
