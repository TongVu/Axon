package com.axonactive.programmingChallenges.chapter7;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {
    static final int TOTAL_PHONE_NUMBERS = 5;
    private ArrayList<PhoneBookEntry> listPhone = new ArrayList<>(TOTAL_PHONE_NUMBERS);


    public PhoneBook() {
        Scanner input = new Scanner(System.in);
        String name, number;

        for (int i = 0; i < TOTAL_PHONE_NUMBERS; i++) {
            System.out.print("Enter persons's name: ");
            name = input.nextLine();

            System.out.print("Enter persons's phone number: ");
            number = input.nextLine();

            listPhone.add(new PhoneBookEntry(name, number));
        }
    }

    public void showData() {
        for (int i = 0; i < listPhone.size(); i++) {
            System.out.println(listPhone.get(i).getPersonName() + " - " + listPhone.get(i).getPhoneNumber());
        }
    }

    public static void main(String[] args) {
        PhoneBook list = new PhoneBook();
        list.showData();
    }
}
