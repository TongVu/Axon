package personal;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex18_WordsCount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str;

        System.out.print("String: ");
        str = input.nextLine();

        StringTokenizer tokens = new StringTokenizer(str);
        System.out.println("The string have: " + tokens.countTokens() + " words");
    }
}
