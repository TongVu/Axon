package com.axonactive.programmingChallenges.chapter7;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PopulationData {
    public static void main(String[] args) throws IOException {

        File fileToRead = new File("USPopulation.txt");
        Scanner file = new Scanner(fileToRead);
        ArrayList<String> fileRecord = new ArrayList<>();
        ArrayList<Integer> fileInt = new ArrayList<>();

        // Write file to the list
        while (file.hasNext()) {
            fileRecord.add(file.nextLine());
        }
        file.close();

        for (int i = 0; i < fileRecord.size(); i++) {
            fileInt.add(Integer.valueOf(fileRecord.get(i)));
        }

/*
the year with the greatest increase in population during the time period
the otherwise
 */
        double averageChangeInPopulation = 0,
                changeInPopulationEveryYear = 0;
        int yearCount = 1,
                greatestIncreaseInPop = fileInt.get(1) - fileInt.get(0),
                smallestIncreaesInPop = fileInt.get(1) - fileInt.get(0);

        for (int i = 1; i < fileInt.size(); i++) {
            changeInPopulationEveryYear += (fileInt.get(i) - fileInt.get(i-1));
            yearCount++;
        }
        averageChangeInPopulation = changeInPopulationEveryYear / yearCount;

        for (int i = 2; i < fileRecord.size(); i++) {
            //check greatest
            if(greatestIncreaseInPop < (fileInt.get(i) - fileInt.get(i-1)) ){
                greatestIncreaseInPop = (fileInt.get(i) - fileInt.get(i-1));
            }

            //check smallest
            if(smallestIncreaesInPop > (fileInt.get(i) - fileInt.get(i-1)) ){
                greatestIncreaseInPop = (fileInt.get(i) - fileInt.get(i-1)) ;
            }
        }

        System.out.printf("Average change in population %.3f\n", averageChangeInPopulation);
        System.out.println("Greatest increase in population: " + greatestIncreaseInPop);
        System.out.println("Smallest increase in population: " + smallestIncreaesInPop);
    }
}
