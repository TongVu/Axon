package com.axonactive.programmingChallenges.chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CharAccountValidation_ArrayList {
    private final ArrayList<Integer> validAccounts = new ArrayList<>(Arrays.asList(
            5658845, 4520125, 8080152, 4562555, 1005231, 6545231,
            7895122, 8777541, 5552012, 5050552, 3852085, 7576651,
            8451277, 7825877, 7881200, 1302850, 1250255, 4581002

    ));

   public CharAccountValidation_ArrayList(){}

    public boolean isValid(int accountId) {
        for (int i = 0; i < validAccounts.size() ; i++) {
            if (accountId == validAccounts.get(i)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        CharAccountValidation_ArrayList accountList = new CharAccountValidation_ArrayList();
        int id;

        Scanner input = new Scanner(System.in);

        System.out.println("Array List");
        System.out.print("Please enter an account ID: ");
        id = input.nextInt();

        if (accountList.isValid(id)) {
            System.out.println("The account is valid");
        } else {
            System.out.println("The account is not valid");
        }

    }
}
