package com.axonactive.programmingChallenges.person;

public class PersonDemo {
    public static void main(String[] args) {
        Person person = new Person();
        person.setFirstName("");
        person.setLastName("");
        person.setAge(10);

        System.out.println("FullName = " + person.getFullName());
        System.out.println("teen = " + person.isTeen());

        person.setFirstName("John");
        person.setAge(18);

        System.out.println("FullName = " + person.getFullName());
        System.out.println("teen =  " + person.isTeen());

        person.setLastName("Smith");
        System.out.println("Full name = " + person.getFullName());
    }
}
