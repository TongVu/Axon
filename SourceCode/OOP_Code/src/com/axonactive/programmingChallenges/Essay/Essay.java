package com.axonactive.programmingChallenges.Essay;

/**
 * A class determines the grade a student receives for an essay.
 * Student's essay score can be up to 100.
 * Score is determined in the following manner:
 * +Grammar: 30 pts
 * +Spelling: 20 pts
 * +Correct Length: 20 pts
 * +Content: 30 pts
 *
 * /Essay
 *
 * /Fields:
 * -grammar: double
 * -spelling: double
 * -correctLength: double
 * -content: double
 *
 * /Methods:
 * +setScore:
 */

public class Essay extends GradedActivity {
    private double grammar;
    private double spelling;
    private double correctLength;
    private double content;

    public Essay(double grammar,
                 double spelling,
                 double correctLength,
                 double content){
        setGrammar(grammar);
        setSpelling(spelling);
        setCorrectLength(correctLength);
        setContent(content);
    }

    public double getGrammar() {
        return grammar;
    }

    public double getSpelling() {
        return spelling;
    }

    public double getCorrectLength() {
        return correctLength;
    }

    public double getContent() {
        return content;
    }

    public void setGrammar(double grammar) {
        if (grammar > 30 || grammar < 0) {
            throw new IllegalArgumentException("Wrong point");
        }
        this.grammar = grammar;
    }

    public void setSpelling(double spelling) {
        if (spelling > 20 || spelling < 0) {
            throw new IllegalArgumentException("Wrong point");
        }
        this.spelling = spelling;
    }

    public void setCorrectLength(double correctLength) {
        if (correctLength > 30 || correctLength < 0) {
            throw new IllegalArgumentException("Wrong point");
        }
        this.correctLength = correctLength;
    }

    public void setContent(double content) {
        if (content > 30 || content < 0) {
            throw new IllegalArgumentException("Wrong point");
        }
        this.content = content;
    }

    public void setScore(){
       double s = this.grammar +
               this.spelling +
               this.content +
               this.correctLength;

       super.setScore(s);
    }
}
