package com.axonactive.programmingChallenges.Challenges;

public class WordFrequency {
    private String word;
    private int frequency;


    public WordFrequency(String word) {
        this.word = word;
        this.frequency = 0;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getFrequency() {
        return frequency;
    }
    public void increase() {
        this.frequency = getFrequency() + 1;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

}
