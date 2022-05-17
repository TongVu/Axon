package com.axonactive.programmingChallenges.chapter7;

import java.util.Scanner;

public class TriviaGame {
    private Question question = new Question();
    private String[] playersAnswers = new String[10]; // player 1 is even, player 2 is odd.

    public void start() {
        String[] list = question.getTriviaQuestions(); // get questions list
        String[] possibleAnswer1 = question.getPossibleAnswers1();
        String[] possibleAnswer2 = question.getPossibleAnswers2();
        String[] possibleAnswer3 = question.getPossibleAnswers3();
        String[] possibleAnswer4 = question.getPossibleAnswers4();
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
            System.out.println("1. " + possibleAnswer1[i]);
            System.out.println("2. " + possibleAnswer2[i]);
            System.out.println("3. " + possibleAnswer3[i]);
            System.out.println("4. " + possibleAnswer4[i]);

            if (i % 2 == 0) {
                System.out.print("Player 1 - enter your answer: ");
                playersAnswers[i] = input.nextLine();
            } else {
                System.out.print("Player 2: - enter your answer: ");
                playersAnswers[i] = input.nextLine();
            }
            System.out.println("=======================================");
        }
    }

    public void showHighestPoint() {
        String[] correctAnswers = question.getNumberOfCorrectAnswer();
        int playerOnePoint = 0,
                playerTwoPoint = 0;

        for (int i = 0; i < correctAnswers.length; i++) {
            if (i % 2 == 0 && correctAnswers[i].equals(playersAnswers[i])) { // player 1 is even
                playerOnePoint++;
            } else if (i % 2 != 0 && correctAnswers[i].equals(playersAnswers[i])) {
                playerTwoPoint++;
            }
        }
        System.out.println("Player 1 points: " + playerOnePoint);
        System.out.println("Player 2 points: " + playerTwoPoint);

        if(playerOnePoint > playerTwoPoint){
            System.out.println("Player 1 is the winner!!!!!");
        } else if(playerOnePoint < playerTwoPoint){
            System.out.println("Player 2 is the winner!!!!!");
        } else{
            System.out.println("Both of you are raw!!!!");
        }
    }

    public static void main(String[] args) {
        TriviaGame game = new TriviaGame();

        game.start();
        game.showHighestPoint();
    }
}

