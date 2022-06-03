package com.axonactive.programmingChallenges.Problem3_Queue;

import java.util.ArrayList;
import java.util.Scanner;

public class QueueDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Scanner input = new Scanner(System.in);
        int n;

        do {
            System.out.print("Enter n: ");
            n = input.nextInt();
        }while(n < 0);

        for (int i = 0; i < n; i++) {
            int val = list.get(0);
            list.remove(0);
            list.add(val);
            list.add(val);
            list.add(val);
        }

        for (int element :
                list) {
            System.out.print(element + "->");
        }
        System.out.print("\b\b");
    }
}
