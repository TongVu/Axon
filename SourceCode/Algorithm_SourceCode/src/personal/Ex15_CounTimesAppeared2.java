package personal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex15_CounTimesAppeared2 {
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
         * 194904139857
         * 77880912432
         * 78822017435
         * */

        List<CharTimes> chars = new ArrayList<>();
        chars.addAll(Arrays.asList(arr));


        // Refined elements which don't suit to requirement
        chars.removeIf(element -> element.getTime() != 2);

        for (int i = 0; i < chars.size(); i++) {
            for (int j = 1; j < chars.size(); j++) {
                if(chars.get(i).getC() == chars.get(j).getC()){
                    chars.remove(chars.get(j));
                }
            }
        }

        for (CharTimes element :
                chars) {
            System.out.print(element.getC() + "->");
        }
        System.out.print("\b\b");

    }
}
