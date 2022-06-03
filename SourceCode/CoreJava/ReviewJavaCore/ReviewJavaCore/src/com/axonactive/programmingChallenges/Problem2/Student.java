package com.axonactive.programmingChallenges.Problem2;

public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private String dob; // dob is day of birth
    private int year; // year is the year that the student enrolled in school

    public Student(){

    }

    public Student(String id,
                   String firstName,
                   String lastName,
                   String dob,
                   int year) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setYear(int year) {
        this.year = year;
    }


    @Override
    public String toString(){
        return "[" +
                this.firstName + " _ " +
                this.lastName + " _ " +
                this.dob + " _ " +
                this.year + "]";
    }
}
