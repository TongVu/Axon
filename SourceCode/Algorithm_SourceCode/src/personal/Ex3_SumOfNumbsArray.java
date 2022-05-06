package personal;

import java.util.Scanner;

public class Ex3_SumOfNumbsArray {
    public static void sumStrNumb(String str) {
        int[] numbArr = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            numbArr[i] = Integer.parseInt(
                    Character.toString(str.charAt(i))
            );
        }
        int sum = 0;
        for (int number :
                numbArr) {
            sum += number;
        }
        System.out.print("Sum of " + str + " : " + sum);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String strNumb = new String();

        System.out.print("String number: ");
        strNumb = input.nextLine();
        sumStrNumb(strNumb);

    }
}
