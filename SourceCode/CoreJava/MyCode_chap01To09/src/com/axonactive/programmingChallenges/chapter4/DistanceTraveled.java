package com.axonactive.programmingChallenges.chapter4;
import java.util.Scanner;

public class DistanceTraveled {
    public static void main(String[] args) {
        //distance = speed * time
        int speed,
                hours;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the speed (mph): ");
        speed = input.nextInt();

        System.out.print("Enter the hours: ");
        hours = input.nextInt();

        System.out.println("Hour ==== Distance traveled");
        System.out.println("===========================");
        for(int hoursCount = 0; hoursCount < hours; hoursCount++){
            int distance = speed * hoursCount;
            System.out.println(hoursCount + " ============== " + distance + " miles");
        }
    }
}
