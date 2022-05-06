package personal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex27 {
    public static void findMaxAndSecondMax(List<Integer> numbersArr){
        int max = numbersArr.get(0); // max now is the first element in the array
        List<Integer> numbersArrayWithoutPreviousMax = new ArrayList<>(); // this array holds number without max

        for (int number :
                numbersArr) {
            if(max < number) max = number; // if max < current number then assign that current number for max
            numbersArrayWithoutPreviousMax.add(number);
        }
        System.out.print("Max : " + max);

        for (int i = 0; i < numbersArrayWithoutPreviousMax.size(); i++) {
            if(max == numbersArrayWithoutPreviousMax.get(i))
                numbersArrayWithoutPreviousMax.remove(i);
        }

        int secondMax = numbersArrayWithoutPreviousMax.get(0);
        for (int number :
                numbersArrayWithoutPreviousMax) {
            if(secondMax < number) secondMax = number;
        }
        System.out.print("\nSecond max: " + secondMax);

    }

    public static void sort(List<Integer> numbs){
        int[] sortedArr = new int[numbs.size()];
        for (int i = 0; i < sortedArr.length; i++) {
            sortedArr[i] = numbs.get(i);
        }

        for (int i = 0; i < sortedArr.length - 1; i++) {
            for (int j = i + 1; j < sortedArr.length; j++) {
                if(sortedArr[i] < sortedArr[j]){
                    int tmp = sortedArr[i];
                    sortedArr[i] = sortedArr[j];
                    sortedArr[j] = tmp;
                }
            }
        }

        System.out.println("\nSorted array");
        for (int number :
                sortedArr){
            System.out.print(number + " -> ");
        }
        System.out.print("\b\b\b");
    }

    public static void addElementWithSorted(List<Integer> numbsArr, int numberAdded){
        int length = numbsArr.size() + 1;
        int[] sortedArr = new int[length];

        for (int i = 0; i < length - 1; i++) {
            sortedArr[i] = numbsArr.get(i);
        }
        sortedArr[length - 1] = numberAdded; // add the number to the last index

        for (int numb :
                sortedArr) {
            System.out.println(numb);
        }
//        // 1 more slot for the number
        for (int i = 0; i < sortedArr.length - 1; i++) {
            for (int j = i + 1; j < sortedArr.length; j++) {
                if(sortedArr[i] < sortedArr[j]){
                    int tmp = sortedArr[i];
                    sortedArr[i] = sortedArr[j];
                    sortedArr[j] = tmp;
                }
            }
        }
        System.out.println("\nAfter add 1 more number");
        for (int numb :
                sortedArr) {
            System.out.print(numb + " ->");
        }
        System.out.print("\b\b");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int elements;
        List<Integer> numbers = new ArrayList<>();

        System.out.print("Enter number of elements in the array: ");
        elements = input.nextInt();

        int elementValue = 0;
        for (int i = 0; i < elements; i++) {
            do {
                System.out.print((i + 1) + ".Enter value: ");
                elementValue = input.nextInt();

                if(elementValue < 100){
                    numbers.add(elementValue);
                }
            } while (elementValue > 100);
        }

        findMaxAndSecondMax(numbers);
        sort(numbers);

        System.out.print("Add 1 more number: ");
        elements = input.nextInt();
        addElementWithSorted(numbers, elements);


    }
}
