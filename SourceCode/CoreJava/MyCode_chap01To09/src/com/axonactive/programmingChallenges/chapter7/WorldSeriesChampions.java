package com.axonactive.programmingChallenges.chapter7;
/*
input: name of a team in World Series
            -> read the WorldSeriesWinners.txt -> store them in an array
output: - number of times that team won the World Series from 1903 to 2009
(World Series 1904 and 1994 didn't take place).
-> do nothing
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WorldSeriesChampions {
    public static void main(String[] args) throws IOException {
        File fileToRead = new File("WorldSeriesWinners.txt");
        Scanner file = new Scanner(fileToRead);
        ArrayList<String> fileRecord = new ArrayList<>();

        // Write file to the list
        while (file.hasNext()) {
            fileRecord.add(file.nextLine());
        }
        file.close();


        String nameOfWinner;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the name you're looking for: ");
        nameOfWinner = input.nextLine();

        System.out.println("Years that " + nameOfWinner + " won: ");

        for (int i = 0; i < fileRecord.size(); i++) {

            if ( nameOfWinner.equals( fileRecord.get(i)) ) {
                if(i + 1903 >= 1904 && i + 1903 < 1994){
                    System.out.print("  " + (i + 1903 + 1));
                } else if(i + 1903 >= 1994){
                    System.out.print("  " + (i + 1903 + 2));
                } else{
                    System.out.print("  " + (i + 1903));
                }
            }
        }

    }
}
