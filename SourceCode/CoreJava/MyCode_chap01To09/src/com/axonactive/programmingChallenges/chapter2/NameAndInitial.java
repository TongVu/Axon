package com.axonactive.programmingChallenges.chapter2;
import java.lang.String;

public class NameAndInitial {
    public static void main(String[] args) {
        String firstName = "Tong",
                middleName = "Phan Hoang",
                lastName = "Vu";

        char firstInitial = firstName.charAt(0),
                middleInitial =  middleName.charAt(0),
                lastInitial =  lastName.charAt(0);
        System.out.println(firstName + " - " + middleName + " - " + lastName);
        System.out.println(firstInitial + " - " + middleInitial + " - " + lastInitial);
    }
}
