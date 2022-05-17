package com.axonactive.programmingChallenges.chapter3;
import java.util.Scanner;
import java.lang.String;

public class SortedNames {
    public static void main(String[] args) {
        String person1, person2, person3;
        char first, second, last, tmp;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter name of person 1: ");
        person1 = input.nextLine();
        first = person1.charAt(0);

        System.out.print("Enter name of person 2: ");
        person2 = input.nextLine();
        second = person2.charAt(0);

        System.out.print("Enter name of person 3: ");
        person3 = input.nextLine();
        last = person3.charAt(0);

        if(first > second){
           tmp = second;
           second = first;
           first = tmp;
        } if(first > last){
            tmp = last;
            last = first;
            first = tmp;
        } if(second > last){
            tmp = last;
            last = second;
            second = tmp;
        }

          if( first == person1.charAt(0) ) {
              System.out.println(person1);
          } else if( first == person2.charAt(0) ) {
              System.out.println(person2);
          }else if ( first == person3.charAt(0) ) {
              System.out.println(person3);
          }


        if( second == person1.charAt(0) ) {
            System.out.println(person1);
        } else if( second == person2.charAt(0) ) {
            System.out.println(person2);
        }else if ( second == person3.charAt(0) ) {
            System.out.println(person3);
        }

        if( last == person1.charAt(0) ) {
            System.out.println(person1);
        } else if( last == person2.charAt(0) ) {
            System.out.println(person2);
        }else if ( last == person3.charAt(0) ) {
            System.out.println(person3);
        }
    }
}
