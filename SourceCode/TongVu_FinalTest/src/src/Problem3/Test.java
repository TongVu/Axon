package Problem3;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str;
        System.out.println("DOB: ");
        str = input.nextLine();

        StringTokenizer tokens = new StringTokenizer(str, "/");
        String[] dayMonthYear = new String[tokens.countTokens()];

        for (int i = 0; i < dayMonthYear.length; i++) {
            dayMonthYear[i] = tokens.nextToken();
        }

        if(Integer.parseInt(dayMonthYear[0]) <= 12
        && Integer.parseInt(dayMonthYear[0]) >= 1 ) System.out.println("OK");

        if(Integer.parseInt(dayMonthYear[1]) <= 31
                && Integer.parseInt(dayMonthYear[1]) >= 1 ) System.out.println("OK");

        if(Integer.parseInt(dayMonthYear[2]) >= 1922 &&
        Integer.parseInt(dayMonthYear[2]) <= 2022)  System.out.println("OK");
    }
}
