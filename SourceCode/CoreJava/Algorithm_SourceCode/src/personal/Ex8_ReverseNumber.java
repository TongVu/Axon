package personal;

public class Ex8_ReverseNumber {
    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) {
            String str = String.valueOf(i);
            System.out.print(str);

            for (int j = (str.length() - 1); j >= 0; j--) {
                System.out.print(str.charAt(j));
            }
            System.out.println();
        }
    }
}
