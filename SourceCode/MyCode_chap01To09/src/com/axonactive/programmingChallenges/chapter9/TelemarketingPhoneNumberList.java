package com.axonactive.programmingChallenges.chapter9;

import java.util.Scanner;

public class TelemarketingPhoneNumberList {
    private static String[] name = {
            "Harrison, Rose", "James, Jean",
            "Smith, William", "Smith Brad",
    };
    private static String[] phone = {
            "555 - 2234", "555 - 9098",
            "555 - 1785", "555 - 9224",
    };

    public static void showLookUp(String searchingVal) {
        for (int i = 0; i < name.length; i++) {
            if (name[i].contains(searchingVal)) System.out.println(name[i] + ": " + phone[i]);
        }
    }

    public static void main(String[] args) {
        String nameSearching;
        Scanner input = new Scanner(System.in);

        System.out.print("What name are you looking for? ");
        nameSearching = input.nextLine();
        showLookUp(nameSearching);

    }

    public static class IndexValue {
        private int index = 0;
        private int value = 0;

        public IndexValue() {
            this.index = 0;
            this.value = 0;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

    }
}
