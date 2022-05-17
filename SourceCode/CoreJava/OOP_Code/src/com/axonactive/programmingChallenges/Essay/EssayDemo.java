package com.axonactive.programmingChallenges.Essay;

public class EssayDemo {
    public static void main(String[] args) {
        Essay myEssay = new Essay(30, 18, 15, 30);
        System.out.println("Grammar: " + myEssay.getGrammar());
        System.out.println("Spelling: " + myEssay.getSpelling());
        System.out.println("Correct length: " + myEssay.getCorrectLength());
        System.out.println("Content: " + myEssay.getContent());

        myEssay.setScore();
        System.out.println("Score: " + myEssay.getScore()
                + " _ Grade: " + myEssay.getGrade());

    }
}
