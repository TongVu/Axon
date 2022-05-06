package com.axonactive.programmingChallenges.CourseGrades;

public class Essay extends GradedActivity{
    private double grammar;
    private double spelling;
    private double correctLength;
    private double content;

    public  Essay(double s){
        super(s);
    }
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

    @Override
    public String toString(){

        return "Essay: " + getScore()
                + " _ Grade: " + getGrade();
    }
}
