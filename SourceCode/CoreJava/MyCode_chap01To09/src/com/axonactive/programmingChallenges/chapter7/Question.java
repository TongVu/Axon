package com.axonactive.programmingChallenges.chapter7;

/*
    string fields for the following data:
   -trivia question
   -possible answer1
   -possible answer2
   -possible answer3
   -possible answer4
   -number of the correct answer(1,2,3,4)
 */
public class Question {

    static final int NUMBER_OF_QUESTIONS = 10;


    private String[] triviaQuestions = {
            "How many legs does a spider have?",// 1 - 8
            "What is the name of the cowboy in Toy Story", // 2 - Woody
            "What is the color of an emerald?", // 3- green
            "What is something you hit with a hammer?", // 4 - a nail
            "What's the name of a place you go to see a lot of animals?", // 5 - zoo
            "Whose nose grew longer every times he lied?", // 6 - Pinocchio
            "If you freeze water, what do you get?", // 7 - ice
            "What color are the stars on the American flag? ", // 8 - white
            "What's the response to \"see you later alligator\"?", // 9 - Goodbye crocodile
            "Where does Santa Clause live?"// 10 - The North Pole
    };

    private String[] possibleAnswers1 = {
            "8", "John", "blue", "a sink", "a swimming pool",
            "Harvard", "snow", "white", "Goobye Giraffe", "The North Pole"
    };

    private String[] possibleAnswers2 = {
            "6", "Woody", "pink", "a stove", "a field",
            "John Wick", "ice", "red", "Goobye Wolf", "America"
    };

    private String[] possibleAnswers3 = {
            "2", "Mark Zukerberg", "orange", "a chair", "a zoo",
            "Witchita", "lake", "white", "Goobye Crocodile", "Asia"
    };

    private String[] possibleAnswers4 = {
            "4", "Jeff Dean", "green", "a nail", "a canyon",
            "Pinocchio", "rock", "black", "Goobye Tiger", "Africa"
    };
    private String[] numberOfCorrectAnswer = {
            "1", "2", "4", "4", "3",
            "4", "2", "3", "3", "1"
    };

    public Question() {
    }

    public void setPossibleAnswers1(String[] possibleAnswers1) {
        this.possibleAnswers1 = possibleAnswers1;
    }

    public void setPossibleAnswers2(String[] possibleAnswers2) {
        this.possibleAnswers2 = possibleAnswers2;
    }

    public void setPossibleAnswers3(String[] possibleAnswers3) {
        this.possibleAnswers3 = possibleAnswers3;
    }

    public void setPossibleAnswers4(String[] possibleAnswers4) {
        this.possibleAnswers4 = possibleAnswers4;
    }

    public String[] getTriviaQuestions() {
        return triviaQuestions;
    }

    public String[] getPossibleAnswers1() {
        return possibleAnswers1;
    }

    public String[] getPossibleAnswers2() {
        return possibleAnswers2;
    }

    public String[] getPossibleAnswers3() {
        return possibleAnswers3;
    }

    public String[] getPossibleAnswers4() {
        return possibleAnswers4;
    }

    public String[] getNumberOfCorrectAnswer() {
        return numberOfCorrectAnswer;
    }

    public void setNumberOfCorrectAnswer(String[] numberOfCorrectAnswer) {
        this.numberOfCorrectAnswer = numberOfCorrectAnswer;
    }
}
