package personal;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex32_FindLongestWord {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str;

        System.out.print("Input a string: ");
        str = input.nextLine();

        StringTokenizer tokens = new StringTokenizer(str);
        int max = 0;
        ArrayList<char[]> charList =  new ArrayList<>();

        while(tokens.hasMoreTokens()){
            charList.add(tokens.nextToken().toCharArray());
        }

        for (char[] charArr :
                charList) {
            if (charArr.length > max) {
                max = charArr.length;
            }
        }

        System.out.println("Longest words: " + max);
        int count = 0;
        for (char[] charArr :
                charList) {
            if (charArr.length == max) {
                System.out.print(charArr );
                System.out.println(" position: " + (count + 1));
            }
            count++;
        }

    }
}
