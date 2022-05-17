package personal;

import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex31_standardizedString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String usrInput;

        System.out.print("Input a string: ");
        usrInput = input.nextLine();

        StringTokenizer tokens = new StringTokenizer(usrInput, " ");
        StringBuilder str = new StringBuilder();

        while(tokens.hasMoreTokens()){
            String tokenToStr = tokens.nextToken().toString();
            tokenToStr = tokenToStr.substring(0,1).toUpperCase() + tokenToStr.substring(1).toLowerCase();
            str.append(tokenToStr).append(" ");
        }

        System.out.println(str.toString());

    }
}
