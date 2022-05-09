package com.axonactive.programmingChallenges.chapter4;
import java.util.Scanner;

public class HourMinuteSecond {
    public static void main(String[] args) {
        int hour, previousHour =0 , nextHour = 0,
                minute, previousMinute = 0, nextMinute = 0,
                second, previousSecond = 0, nextSecond = 0,
                flag = 0;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter hour: ");
        hour = input.nextInt();
        if(hour < 0 || hour > 23){
            System.out.print("Invalid hour!!!");
            flag = 1;
        }

        System.out.print("Enter minute: ");
        minute = input.nextInt();
        if(minute < 0 || minute > 59){
            System.out.print("Invalid minute!!!");
            flag = 1;
        }

        System.out.print("Enter second: ");
        second = input.nextInt();
        if(second < 0 || second > 60){
            System.out.print("Invalid second!!!");
            flag = 1;
        }

        if (flag == 1){
            System.out.println("The time is invalidated");
        }

        // Normal
        if (second != 59 && second != 0){
            previousSecond = second - 1;
            nextSecond = second + 1;

            previousMinute = minute;
            nextMinute = minute;

            previousHour = hour;
            nextHour = hour;
        }

        if (second == 59){
            previousSecond = 58;
            nextSecond = 0;

            if (minute == 59){
                nextMinute = 0;
                previousMinute = minute;
                if(hour == 23){
                    previousHour = hour;
                    nextHour = 0;
                } else{
                    previousHour = hour;
                    nextHour = hour + 1;
                }
            } else if(minute != 59){
                nextMinute = minute;
                previousMinute = minute;
                nextHour = hour;
                previousHour = hour;
            }
        } else if(second == 0){
            previousSecond = 59;
            nextSecond = 1;
            if(minute == 0){
                previousMinute = 59;
                nextMinute = minute;
                if(hour == 0){
                   previousHour = 23;
                   nextHour = hour;
                } else{
                    previousHour = hour - 1;
                    nextHour = hour;
                }
            }
        }

        System.out.println("Previous Time: " + previousHour + ":" + previousMinute + ":" + previousSecond);
        System.out.println("Current Time: " + hour + ":" + minute + ":" + second);
        System.out.println("Next Time: " + nextHour + ":" + nextMinute + ":" + nextSecond);
    }
}
