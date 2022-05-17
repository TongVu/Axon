package com.axonactive.programmingChallenges.chapter9;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LotteryStatistics {

    public static void mostCommonNumb(IndexValue[] arr) {
        // find 10 most Common Times
        IndexValue[] mostCommon = new IndexValue[arr.length];
        for (int i = 0; i < arr.length; i++) {
            mostCommon[i] = new IndexValue();
            mostCommon[i].setIndex(arr[i].getIndex());
            mostCommon[i].setValue(arr[i].getValue());
        }

        // TODO This work but it's not as I expected, I'll come back later
        for (int i = 0; i < mostCommon.length; i++) {
            for (int j = 0; j < mostCommon.length; j++) {
                if (mostCommon[i].getValue() > mostCommon[j].getValue()) {
                    IndexValue tmp = new IndexValue();
                    // assign current for tmp
                    tmp.setIndex(mostCommon[i].getIndex());
                    tmp.setValue(mostCommon[i].getValue());

                    mostCommon[i].setIndex(mostCommon[j].getIndex());
                    mostCommon[i].setValue(mostCommon[j].getValue());

                    mostCommon[j].setIndex(tmp.getIndex());
                    mostCommon[j].setValue(tmp.getValue());
                }
            }
        }

        System.out.println("MOST 10 COMMON NUMBER");
        for (int i = 1; i <= 10; i++) {
            System.out.println(
                    mostCommon[i].getIndex() + ": " + mostCommon[i].getValue() + " times."
            );
        }
    }

    public static void mostLeastCommonNumb(IndexValue[] arr) {
        // find 10 most LEAST Common Times
        IndexValue[] leastCommon = new IndexValue[arr.length];
        for (int i = 0; i < arr.length; i++) {
            leastCommon[i] = new IndexValue();
            leastCommon[i].setIndex(arr[i].getIndex());
            leastCommon[i].setValue(arr[i].getValue());
        }

        // TODO This work but it's not as I expected, I'll come back later
        for (int i = 1; i < leastCommon.length; i++) {
            for (int j = 1; j < leastCommon.length; j++) {
                if (leastCommon[i].getValue() < leastCommon[j].getValue()) {
                    IndexValue tmp = new IndexValue();
                    // assign current for tmp
                    tmp.setIndex(leastCommon[i].getIndex());
                    tmp.setValue(leastCommon[i].getValue());

                    leastCommon[i].setIndex(leastCommon[j].getIndex());
                    leastCommon[i].setValue(leastCommon[j].getValue());

                    leastCommon[j].setIndex(tmp.getIndex());
                    leastCommon[j].setValue(tmp.getValue());
                }
            }
        }

        for (int i = 1; i <= 10; i++) {
            System.out.println(
                    leastCommon[i].getIndex() + ": " + leastCommon[i].getValue() + " times."
            );
        }
    }

    public static void displayFrequency(IndexValue[] arr, String[][] dailyLot) {
        // Frequency of numbers
        for (int i = 1; i < arr.length; i++) {
            System.out.println(arr[i].getIndex() + ": " + arr[i].getValue() + " times");
        }

        // INIT POWERBALL-FREQUENCY ARRAY
        // create new array for power ball numbers
        int PB_RANGE = 40; // the book said that powerball number in range 1 - 35, but in fact I found it from 1 - 39
        IndexValue[] pbVal = new IndexValue[PB_RANGE];
        for (int i = 0; i < pbVal.length; i++) {
            pbVal[i] = new IndexValue();
        }

        for (int i = 0; i < dailyLot.length; i++) {
            for (int j = 5; j < dailyLot[i].length; j += 5) {
                int position = Integer.parseInt(dailyLot[i][j]);
                pbVal[position].setIndex(position);
                pbVal[position].setValue(pbVal[position].getValue() + 1);
            }
        }

        System.out.println("==========================");
        System.out.println("FREQUENCY OF POWERBALL NUMBERS:");
        for (int i = 1; i < pbVal.length; i++) {
            if (pbVal[i].getIndex() <= 26) {
                System.out.println(pbVal[i].getIndex() + ": " + pbVal[i].getValue() + " times");
            }
        }
    }

    public static void displayMostOverdue(IndexValue[] arr) {
        mostLeastCommonNumb(arr);
    }

    public static void main(String[] args) throws IOException {
        int ROWS = 654,
                COLUMNS = 6,
                RANGE = 70;


        String FILE_NAME = "pbnumbers.txt";

        Scanner fileInput = new Scanner(new File(FILE_NAME));
        String[][] dailyLot = new String[ROWS][COLUMNS];

        // INIT 2-d ARRAY STRING WITH THE DATA
        for (int i = 0; i < dailyLot.length; i++) {
            for (int j = 0; j < dailyLot[i].length; j++) {
                if (fileInput.hasNext())
                    dailyLot[i][j] = fileInput.next();
            }
        }
        fileInput.close();

        IndexValue[] idxVal = new IndexValue[RANGE];
        for (int i = 0; i < idxVal.length; i++) {
            idxVal[i] = new IndexValue();
        }

        // INIT INDEX-FREQUENCY ARRAY
        for (int i = 0; i < dailyLot.length; i++) {
            for (int j = 0; j < dailyLot[i].length; j++) {
                int position = Integer.parseInt(dailyLot[i][j]);
                idxVal[position].setIndex(position);
                idxVal[position].setValue(idxVal[position].getValue() + 1);
            }
        }

        // FIND 10 MOST COMMON NUMBERS
        mostCommonNumb(idxVal);

        System.out.println("==========================");
        // FIND 10 MOST LEAST COMMON NUMBERS
        System.out.println("MOST LEAST 10 COMMON NUMBER");
        mostLeastCommonNumb(idxVal);

        System.out.println("==========================");
        // DISPLAY 10 MOST OVERDUE NUMBER, ORDERED FROM MOST OVERDUE TO LEAST OVERDUE
        System.out.println("MOST OVERDUE NUMBER");
        displayMostOverdue(idxVal);


        System.out.println("=========== Frequency ===========");
        // DISPLAY FREQUENCY OF EACH NUMBER FROM 1 -69 AND FREQUENCY OF EACH POWERBALL NUMBER FROM 1 - 26

        displayFrequency(idxVal, dailyLot);

    }
}

