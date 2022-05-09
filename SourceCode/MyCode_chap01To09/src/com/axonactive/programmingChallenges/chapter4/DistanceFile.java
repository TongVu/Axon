package com.axonactive.programmingChallenges.chapter4;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DistanceFile {
    public static void main(String[] args) throws IOException
    {
        //distance = speed * time
        int speed,
                hours;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the speed (mph): ");
        speed = input.nextInt();

        System.out.print("Enter the hours: ");
        hours = input.nextInt();

        // WRITE OUTPUT FOR A FILE
        PrintWriter outputFile = new PrintWriter("distance_report.txt");
        outputFile.println("Hour ==== Distance traveled");
        outputFile.println("===========================");

        for(int hoursCount = 0; hoursCount < hours; hoursCount++){
            int distance = speed * hoursCount;
           outputFile.println(hoursCount + " ============== " + distance + " miles");
        }
        // REMEMBER TO CLOSE FILE
        outputFile.close();
    }
}
