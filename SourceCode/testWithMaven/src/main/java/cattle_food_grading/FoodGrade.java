package cattle_food_grading;

import java.util.NoSuchElementException;

public class FoodGrade {
    private String grade;

    public FoodGrade(String grade) {
        this.grade = grade;
    }

    public FoodGrade() {
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        if(grade.compareToIgnoreCase("A") != 0 &&
            grade.compareToIgnoreCase("B") != 0 &&
            grade.compareToIgnoreCase("C") != 0)
            throw new NoSuchElementException();
        else this.grade = grade;
    }

    public int getPrice(){
        if(getGrade().equals("A")) return 30;
        if(getGrade().equals("B")) return 20;

        return 10;
    }
}

