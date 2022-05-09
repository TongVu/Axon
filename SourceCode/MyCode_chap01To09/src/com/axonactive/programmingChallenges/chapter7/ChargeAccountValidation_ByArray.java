package com.axonactive.programmingChallenges.chapter7;

import java.util.Scanner;

public class ChargeAccountValidation_ByArray {
    private final Integer[] validAccounts = {
            5658845, 4520125, 8080152, 4562555, 1005231, 6545231,
            7895122, 8777541, 5552012, 5050552, 3852085, 7576651,
            8451277, 7825877, 7881200, 1302850, 1250255, 4581002
    };

    public ChargeAccountValidation_ByArray() { }

    public boolean isValid(int accountId) {

        for (int i = 0; i < validAccounts.length; i++) {
            if (accountId == validAccounts[i]) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ChargeAccountValidation_ByArray accountList = new ChargeAccountValidation_ByArray();
        int id;

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter an account ID: ");
        id = input.nextInt();

        if (accountList.isValid(id)) {
            System.out.println("The account is valid");
        } else {
            System.out.println("The account is not valid");
        }
    }
}
