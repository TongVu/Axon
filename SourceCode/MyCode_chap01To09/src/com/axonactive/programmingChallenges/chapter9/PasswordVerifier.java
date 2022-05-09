package com.axonactive.programmingChallenges.chapter9;

import java.util.Scanner;

public class PasswordVerifier {
    public static boolean verifyPwd(String usrPwd) {

        return checkDigit(usrPwd) &&
                checkLength(usrPwd) &&
                checkUpperAndLower(usrPwd);
    }

    public static boolean checkUpperAndLower(String usrPwd) {
        boolean lowerCase = false,
                upperCase = false;

        // check lowerCase
        for (int i = 0; i < usrPwd.length(); i++) {
            if ('a' <= usrPwd.charAt(i) && usrPwd.charAt(i) <= 'z') {
                lowerCase = true;
                break;
            }
        }

        // check upperCase
        for (int i = 0; i < usrPwd.length(); i++) {
            if ('A' <= usrPwd.charAt(i) && usrPwd.charAt(i) <= 'Z') {
                upperCase = true;
                break;
            }
        }

        return (upperCase && lowerCase);
    }

    public static boolean checkDigit(String usrPwd) {

        for (int i = 0; i < usrPwd.length(); i++) {
            if ('0' <= usrPwd.charAt(i) && usrPwd.charAt(i) <= '9') {
                return true;
            }
        }

        return false;
    }

    public static boolean checkLength(String usrPwd) {
        return (usrPwd.length() < 6);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String usrPwd;

        do {
            System.out.println("Password has to have least 1 digit, 1 uppercase, 1 lowercase, and at least 6 characters.");
            System.out.println("Enter your password: ");
            usrPwd = input.nextLine();
        } while (!verifyPwd(usrPwd));

        System.out.println("Congratulation! Your password has been set");
    }
}
