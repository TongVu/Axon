package personal;

import java.util.Scanner;

public class Ex16_PrintNTimeAppeared {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str;

        System.out.print("n: ");
        str = input.nextLine();

        CharTimes[] arr = new CharTimes[str.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new CharTimes(str.charAt(i));
        }

        for (int i = 0; i < str.length(); i++) {
            for (CharTimes charTimes : arr) {
                if (str.charAt(i) == charTimes.getC()) charTimes.setTime(charTimes.getTime() + 1);
            }
        }

        /*
         * test:
         * 912131649801
         * 12384798573252141
         * */

        for (CharTimes elm :
                arr) {
            System.out.println(elm.getC() + " -> frequency: " + elm.getTime());
        }
    }
}
