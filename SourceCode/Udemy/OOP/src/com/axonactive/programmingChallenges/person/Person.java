package com.axonactive.programmingChallenges.person;

public class Person {
    private String firstName;
    private String lastName;
    private int age;


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

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isTeen(){
        return 12 < age && age < 20;
    }

    public String getFullName(){
        if(firstName.isEmpty() &&
                lastName.isEmpty()) return " ";
        if(lastName.isEmpty()) return firstName;
        if(firstName.isEmpty()) return  lastName;

        return firstName + " " + lastName;
    }
}
